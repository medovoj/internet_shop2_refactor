package SecurityFilter;

import WebUtils.SessionUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.ShoppingCart;
import Filter.AbstractFilter;
import service.OrderService;
import service.impl.ServiceManager;

import java.io.IOException;

@WebFilter(filterName="AutoRestoreShoppingCartFilter")
public class AutoRestoreShoppingCartFilter extends AbstractFilter {
    private static final String SHOPPING_CARD_DESERIALIZATION_DONE = "SHOPPING_CARD_DESERIALIZATION_DONE";

    private OrderService orderService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        orderService = ServiceManager.getInstance(filterConfig.getServletContext()).getOrderService();
    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if(req.getSession().getAttribute(SHOPPING_CARD_DESERIALIZATION_DONE) == null){
            if(!SessionUtils.isCurrentShoppingCartCreated(req)) {
                Cookie cookie = SessionUtils.findShoppingCartCookie(req);
                if(cookie != null) {
                    ShoppingCart shoppingCart = null;
                    if(shoppingCart != null) {
                        SessionUtils.setCurrentShoppingCart(req, shoppingCart);
                    }
                }
            }
            req.getSession().setAttribute(SHOPPING_CARD_DESERIALIZATION_DONE, Boolean.TRUE);
        }
        chain.doFilter(req, resp);
    }
}

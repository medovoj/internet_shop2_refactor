package SecurityFilter;

import WebUtils.SessionUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.ShoppingCart;
import Filter.AbstractFilter;

import java.io.IOException;

@WebFilter(filterName = "AutoRestoreShoppingCartFilter")
public class AutoRestoreShoppingCartFilter extends AbstractFilter {

    private static final String SHOPPING_CART_DESERIALIZATION_DONE = "SHOPPING_CART_DESERIALIZATION_DONE";


    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletRequest.getSession().getAttribute(SHOPPING_CART_DESERIALIZATION_DONE) == null) {
            if (!SessionUtils.isCurrentShoppingCartCreated(servletRequest)) {
                Cookie cookie = SessionUtils.findShoppingCartCookie(servletRequest);
                if (cookie != null) {
                    ShoppingCart shoppingCart = shoppingCartFromString(cookie.getValue());
                    SessionUtils.setCurrentShoppingCart(servletRequest, shoppingCart);
                }
            }
            servletRequest.getSession().setAttribute(SHOPPING_CART_DESERIALIZATION_DONE, Boolean.TRUE);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    protected ShoppingCart shoppingCartFromString(String cookieValue) {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = cookieValue.split("\\|");
        for (String item : items) {
            String data[] = item.split("-");
            try {
                int idProduct = Integer.parseInt(data[0]);
                int count = Integer.parseInt(data[1]);
                shoppingCart.addProduct(idProduct, count);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return shoppingCart;
    }
}

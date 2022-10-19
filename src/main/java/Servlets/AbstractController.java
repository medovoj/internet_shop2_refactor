package Servlets;

import Form.ProductForm;
import Form.SearchForm;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import service.OrderService;
import service.ProductService;
import service.SocialService;
import service.impl.ServiceManager;


public abstract class AbstractController extends HttpServlet {

    private ProductService productService;
    private OrderService orderService;
    private SocialService socialService;

    @Override
    public final void init() {
        productService = ServiceManager.getInstance(getServletContext()).getProductService();
        orderService = ServiceManager.getInstance(getServletContext()).getOrderService();
        socialService = ServiceManager.getInstance(getServletContext()).getSocialService();
    }

    public final ProductService getProductService() {
        return productService;
    }

    public final OrderService getOrderService() {
        return orderService;
    }

    public SocialService getSocialService() { return socialService;  }

    public final int getPageCount(int totalCount, int itemsPerPage) {
        int res = totalCount / itemsPerPage;
        if (res * itemsPerPage != totalCount) {
            res++;
        }
        return res;
    }

    public final int getPage(HttpServletRequest request) {
        try {
            return Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    public final SearchForm createSearchForm(HttpServletRequest request) {
        return new SearchForm(
                request.getParameter("query"),
                request.getParameterValues("category"),
                request.getParameterValues("producer"));
    }

    public final ProductForm createProductForm(HttpServletRequest request) {
        return new ProductForm(
                Integer.parseInt(request.getParameter("idProduct")),
                Integer.parseInt(request.getParameter("count")));
    }
}

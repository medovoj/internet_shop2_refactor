package Servlets;

import Form.SearchForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import service.OrderService;
import service.ProductService;
import service.impl.ServiceManager;


public abstract class AbstractController extends HttpServlet {

    private ProductService productService;
    private OrderService orderService;


    public final ProductService getProductService() {

        return productService;
    }

    public final OrderService getOrderService() {
        return
                orderService;
    }

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

    public final SearchForm createSearchForm(HttpServletRequest request){
        return new SearchForm(
                request.getParameter("query"),
                request.getParameterValues("category"),
                request.getParameterValues("producer"));
    }

    @Override
    public final void init() throws ServletException {
        productService = ServiceManager.getInstance(getServletContext()).getProductService();
        orderService = ServiceManager.getInstance(getServletContext()).getOrderService();
    }

}

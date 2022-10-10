package Servlets.ajax;

import Servlets.AbstractController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utils.RoutingUtils;

import java.io.IOException;

@WebServlet("/ajax/html/more/search")
public class SearchResultsMoreController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoutingUtils.forwardToFragment("product-list.jsp", req, resp);
    }
}

package Servlets;

import Model.ShoppingCart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.RoutingUtils;

import java.io.IOException;

@WebServlet("/shopping-cart1")
public class ShoppingCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart shoppingCart = (ShoppingCart) request.getSession();
        request.setAttribute("shopping-cart", shoppingCart);
        RoutingUtils.forwardToPage("shoppingCart.jsp", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

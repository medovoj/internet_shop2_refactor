package Servlets.ajax;

import Form.ProductForm;
import Model.ShoppingCart;
import utils.SessionUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/ajax/json/product/add")
public class AddProductController extends AbstractProductController {

    @Override
    protected void processProductForm(ProductForm form, ShoppingCart shoppingCart, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getOrderService().addProductToShoppingCart(form, shoppingCart);
        String cookieValue = getOrderService().serializeShoppingCart(shoppingCart);
        SessionUtils.updateCurrentShoppingCartCookie(cookieValue, resp);
    }
}

package Servlets.ajax;

import Form.ProductForm;
import Model.ShoppingCart;
import Servlets.AbstractController;
import utils.SessionUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import utils.RoutingUtils;

import java.io.IOException;

public abstract class AbstractProductController extends AbstractController {

    @Override
    protected final void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductForm form = createProductForm(req);
        ShoppingCart shoppingCart = SessionUtils.getCurrentShoppingCart(req);
        processProductForm(form, shoppingCart, req, resp);
        sendResponse(shoppingCart, req, resp);
    }

    protected abstract void processProductForm(ProductForm form, ShoppingCart shoppingCart, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException;

    protected void sendResponse(ShoppingCart shoppingCart, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject cardStatistics = new JSONObject();
        cardStatistics.put("totalCount", shoppingCart.getTotalCount());
        cardStatistics.put("totalCost", shoppingCart.getTotalCost());
        RoutingUtils.sendJSON(cardStatistics, req, resp);
    }
}

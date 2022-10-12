package service;

import Form.ProductForm;
import Model.CurrentAccount;
import Model.ShoppingCart;
import Model.SocialAccount;

public interface OrderService {

    void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart);

    void removeProductFromShoppingCart(ProductForm form, ShoppingCart shoppingCart);

    String serializeShoppingCart(ShoppingCart shoppingCart);

    ShoppingCart deserializeShoppingCart(String string);

    CurrentAccount authenticate(SocialAccount socialAccount);

}

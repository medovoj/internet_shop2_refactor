package service;

import Form.ProductForm;
import Model.ShoppingCart;

public interface OrderService {

    void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart);



}

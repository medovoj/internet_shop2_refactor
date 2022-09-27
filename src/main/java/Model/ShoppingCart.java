package Model;


import Exception.ValidationException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import Constants.Constants;



public class ShoppingCart implements Serializable {

    private final Map<Integer, CartItem> products = new HashMap<>();
    private int totalCount = 0;

    public void addProduct(int idProduct, int count) {
        validateShoppingCartSize(idProduct);
        CartItem shoppingCartItem = products.get(idProduct);
        if (shoppingCartItem == null) {
            validateProductCount(count);
            shoppingCartItem = new CartItem(idProduct, count);
            products.put(idProduct, shoppingCartItem);
        } else {
            validateProductCount(count + shoppingCartItem.getCount());
            shoppingCartItem.setCount(shoppingCartItem.getCount() + count);
        }
        refreshStatistics();
    }

    public void removeProduct(Integer idProduct, int count) {
        CartItem shoppingCartItem = products.get(idProduct);
        if (shoppingCartItem != null) {
            if (shoppingCartItem.getCount() > count) {
                shoppingCartItem.setCount(shoppingCartItem.getCount() - count);
            } else {
                products.remove(idProduct);
            }
            refreshStatistics();
        }
    }

    public Collection<CartItem> getItems() {
        return products.values();
    }

    public int getTotalCount() {
        return totalCount;
    }

    private void validateProductCount(int count) {
        if (count > Constants.MAX_PRODUCTS_COUNT) {
            throw new ValidationException("Limit for product count reached: count=" + count);
        }
    }

    private void validateShoppingCartSize(int idProduct) {
        if (products.size() > Constants.MAX_PRODUCTS_CART_CAPACITY ||
                (products.size() == Constants.MAX_PRODUCTS_CART_CAPACITY && !products.containsKey(idProduct))) {
            throw new ValidationException("Limit for ShoppingCart size reached: size=" + products.size());
        }
    }

    private void refreshStatistics() {
        totalCount = 0;
        for (CartItem shoppingCartItem : getItems()) {
            totalCount += shoppingCartItem.getCount();
        }
    }

    @Override
    public String toString() {
        return String.format("ShoppingCart [products=%s, totalCount=%s]", products, totalCount);
    }

    public String getView (){
        StringBuilder sb = new StringBuilder();
        for (CartItem item : getItems()) {
            sb.append(item.getIdProduct()).append("-&gt;").append(item.getCount()).append("<br>");
        }
        return sb.toString();
    }
}

package Model;

import java.io.Serializable;

public class CartItem implements Serializable {
    private int idProduct;
    private int count;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CartItem(int idProduct, int count) {
        this.idProduct = idProduct;
        this.count = count;
    }
}

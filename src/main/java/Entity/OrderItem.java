package Entity;

import framework.annotation.jdbc.Child;
import framework.annotation.jdbc.Column;

public class OrderItem extends AbstractEntity<Long> {

    @Column("id_order")
    private Long idOrder;
    @Child(columnName = "id_product")
    private Product product;
    private Integer count;

    public OrderItem() {
    }

    public OrderItem(Product product, Integer count) {
        super();
        this.product = product;
        this.count = count;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdItem() {
        return idOrder;
    }

    public void setIdItem(Long idItem) {
        this.idOrder = idItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("OrderItem [id=%s, idOrder=%s, product=%s, count=%s]", getId(), idOrder, product, count);
    }
}

package Entity;

import framework.annotation.jdbc.Column;
import framework.annotation.jdbc.Transient;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Order extends AbstractEntity<Long> {
    @Column("id_account")
    private Integer idAccount;
    @Transient
    private List<OrderItem> items;
    private Timestamp created;

    public Order() {
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public BigDecimal getTotalCost() {
        BigDecimal cost = BigDecimal.ZERO;
        if (items != null) {
            for (OrderItem item :
                    items) {
                cost = cost.add(item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getCount())));
            }
        }
        return cost;
    }
}

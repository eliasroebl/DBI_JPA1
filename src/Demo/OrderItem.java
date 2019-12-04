package Demo;

import javax.persistence.*;

@Entity
public class OrderItem {
    @EmbeddedId
    private OrderItemID id;
    private int amount;

    public OrderItemID getId() {
        return id;
    }

    public void setId(OrderItemID id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

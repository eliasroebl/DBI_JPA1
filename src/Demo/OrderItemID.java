package Demo;


import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class OrderItemID implements Serializable {

    @ManyToOne()
    @JoinColumn(name = "id",referencedColumnName = "id")
    private Order order;

    @ManyToOne()
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product;


    public OrderItemID(){}

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }
}


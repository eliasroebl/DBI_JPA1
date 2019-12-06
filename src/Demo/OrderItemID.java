package Demo;


import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class OrderItemID implements Serializable {

    @ManyToOne()
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private Order order;

    @ManyToOne()
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product;


    public OrderItemID(){}

    public OrderItemID(Order o, Product p){
        this.order = o;
        this.product = p;
    }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }
}


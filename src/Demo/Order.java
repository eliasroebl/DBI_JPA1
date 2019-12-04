package Demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Order {
    @Id
    private int id;

    private Date orderDate;
    private short orderState;
    @OneToMany(mappedBy = "id.order",cascade = CascadeType.PERSIST)
    List<OrderItem> orderItems = new LinkedList<OrderItem>();


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "SSN", referencedColumnName = "SSN"),
            @JoinColumn(name = "addressNo", referencedColumnName = "addressNo")
    })
    private Address address;


    public int getId() {
        return id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public short getOrderState() {
        return orderState;
    }

    public void setOrderState(short orderState) {
        this.orderState = orderState;
    }
}

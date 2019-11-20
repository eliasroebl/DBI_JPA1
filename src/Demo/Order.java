package Demo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Order {
    @Id
    private int id;
    @EmbeddedId
    private AddressID addressID;
    private Date orderDate;
    private short orderState;

    public int getId() {
        return id;
    }

    public AddressID getAddressID() {
        return addressID;
    }

    public void setAddressID(AddressID addressID) {
        this.addressID = addressID;
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

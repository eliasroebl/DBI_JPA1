package Demo;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    private int id;
    //TODO: Annotations
    private int product_id;
    private int amount;
}

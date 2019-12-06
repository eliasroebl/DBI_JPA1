package Demo;

import javax.persistence.*;
import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersonPU");
        EntityManager em = factory.createEntityManager();




        Query query = em.createQuery("select p from Person p");

        List<Person> result = query.getResultList();
        for (Person p : result){
            System.out.println(p.getsSSN() + ": " + p.getFirstName() + " " + p.getLastName());
        }
        List<String> cities = query1(em);


        Product p1 = new Product(0,"Product 1",BigDecimal.valueOf(7.5));
        Product p2 = new Product(1,"Product 2",BigDecimal.valueOf(22.75));

        //insertProduct(em, p1);
        //insertProduct(em, p2)

        /*List<OrderItem> orderItems = new ArrayList<OrderItem>();

        Order order = new Order();

        OrderItemID orderItemID1 = new OrderItemID(order,p1);
        OrderItemID orderItemID2 = new OrderItemID(order,p2);
        OrderItem orderItem1 = new OrderItem(orderItemID1,10);
        OrderItem orderItem2 = new OrderItem(orderItemID2,541);
        orderItems.add(orderItem1);
        orderItems.add(orderItem2);

        order.setOrderDate(Date.valueOf(LocalDate.now()));
        order.setOrderItems(orderItems);
        order.setOrderState((short)1);
        order.setAddress((Address) em.createQuery("select a from Address a").getResultList().get(0));

        insertOrder(em,order);*/




        em.close();
        factory.close();
    }

    private static List<String> query1(EntityManager em) {
        List<String> cities = em.createQuery("select distinct a.city from Person p join p.addresses a where p.isAwesome = true order by a.city").getResultList();
        return cities;
    }



    private static void insertPerson(EntityManager em ){
        em.getTransaction().begin();
        Person newPerson = new Person();
        newPerson.setsSSN("5555050670");
        newPerson.setFirstName("Java");
        newPerson.setLastName("Student");
        newPerson.setDateOfBirth(Date.from(LocalDate.of(1970,6,5).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        newPerson.setAwesome(false);
        newPerson.setAwesomeness(-8.12);
        //newPerson.setAddresses();
        em.persist(newPerson);
        em.getTransaction().commit();
    }

    private static void insertAddress(EntityManager em,Person p) {
        em.getTransaction().begin();
        Address newAddress = new Address();
        AddressID addressID = new AddressID(p);
        newAddress.setId(addressID);
        newAddress.setCountry("Austria");
        newAddress.setCity("Leonding");
        newAddress.setStreet("Straße");
        newAddress.setStreetNo((short)3);
        addressID.setPerson(p);

        em.persist(newAddress);
        em.getTransaction().commit();
    }

    private static void insertProduct(EntityManager em, Product p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

    }

    private static void insertOrder(EntityManager em, Order o){
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();

    }

}

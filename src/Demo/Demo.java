package Demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Dictionary;
import java.util.List;

public class Demo {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersonPU");
        EntityManager em = factory.createEntityManager();


        //insertPerson(em);

        Query query = em.createQuery("select p from Person p");
        List<Person> result = query.getResultList();
        for (Person p : result){
            System.out.println(p.getsSSN() + ": " + p.getFirstName() + " " + p.getLastName());
        }
        //insertAddress(em,result.get(3));
        List<String> cities = query1(em);
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

}

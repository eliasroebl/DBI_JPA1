package Demo;

import javax.persistence.*;

@Entity
public class Address {
    @EmbeddedId
    private AddressID id;
    private String country;
    private String city;
    private String Street;
    private short StreetNo;

    @ManyToOne()
    @JoinColumn(name = "ssn",insertable = false,updatable = false)
    private Person person;

    public AddressID getId() {
        return id;
    }

    public void setId(AddressID id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public short getStreetNo() {
        return StreetNo;
    }

    public void setStreetNo(short streetNo) {
        StreetNo = streetNo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

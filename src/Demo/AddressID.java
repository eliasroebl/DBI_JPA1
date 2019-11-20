package Demo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AddressID implements Serializable {
    private short AddressNo;

    @ManyToOne()
    @JoinColumn(name = "ssn")
    private Person person;


    AddressID(Person p){
        setAddressNo((short)p.getAddresses().size());
    }

    public AddressID() {

    }


    public short getAddressNo() {
        return AddressNo;
    }

    public void setAddressNo(short addressNo) {
        AddressNo = addressNo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}


package Demo;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AddressID implements Serializable {
    private String SSN;
    private short AddressNo;

    AddressID(String s, short i) {
        setSSN(s);
        setAddressNo(i);
    }

    public AddressID() {

    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public short getAddressNo() {
        return AddressNo;
    }

    public void setAddressNo(short addressNo) {
        AddressNo = addressNo;
    }
}


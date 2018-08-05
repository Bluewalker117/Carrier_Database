package RJN.Steel.Carrier.Database.models;

import org.apache.tomcat.jni.Address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.InterfaceAddress;

@Entity
public class Carrier {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Size(min = 3, message= "A minimum of three (3) characters must be entered")
    private String name;

 //   private Address addressPhysical;

 //   private InterfaceAddress addressEmailGeneral;









    public Carrier() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public String getAddress() { return address; }

    //public void setAddress(String address) { this.address = address; }
}

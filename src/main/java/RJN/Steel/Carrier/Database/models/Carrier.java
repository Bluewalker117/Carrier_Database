package RJN.Steel.Carrier.Database.models;

import org.apache.tomcat.jni.Address;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.net.InterfaceAddress;

@Entity
@Indexed
@Table(name = "carrier")
public class Carrier {

    @Id
    @GeneratedValue
    private Integer id;

    @Field(store = Store.NO)
    @NotNull
    @Size(min = 3, message= "A minimum of three (3) characters must be entered")
    private String name;

    private String addressEmailGeneral;

    private String addressEmailPattern;

    @Pattern(regexp = "(^$|(\\d{3}[-]\\d{3}[-]\\d{4}))", message = "Phone number must be in the format of 111-111-1111")
    private String phoneNumber;

    private String claimNumber;

    private String policyNumber;

    private String memberOfHub;

    private String memberOfArb;

    private Integer navigatorId;





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

   public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddressEmailGeneral() { return addressEmailGeneral; }

    public void setAddressEmailGeneral(String addressEmailGeneral) { this.addressEmailGeneral = addressEmailGeneral; }

    public String getAddressEmailPattern() { return addressEmailPattern; }

    public void setAddressEmailPattern(String addressEmailPattern) { this.addressEmailPattern = addressEmailPattern; }

    public String getClaimNumber() { return claimNumber; }

    public void setClaimNumber(String claimNumber) { this.claimNumber = claimNumber; }

    public String getPolicyNumber() { return policyNumber; }

    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public String getMemberOfHub() { return memberOfHub; }

    public void setMemberOfHub(String memberOfHub) { this.memberOfHub = memberOfHub; }

    public String getMemberOfArb() { return memberOfArb; }

    public void setMemberOfArb(String memberOfArb) { this.memberOfArb = memberOfArb; }

    public Integer getNavigatorId() { return navigatorId; }

    public void setNavigatorId(Integer navigatorId) { this.navigatorId = navigatorId; }
}

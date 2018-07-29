package RJN.Steel.Carrier.Database.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Carrier {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Size(min = 3, message= "A minimum of three (3) characters must be entered")
    private String name;



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
}

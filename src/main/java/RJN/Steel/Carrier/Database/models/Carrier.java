package RJN.Steel.Carrier.Database.models;

public class Carrier {

    private Integer id;

    private String name;


    public Carrier() {}

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

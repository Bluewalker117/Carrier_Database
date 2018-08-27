package RJN.Steel.Carrier.Database.models;

public enum SearchType {

    NAME ("Name"),
    GENERAL ("General");

    private final String name;

    SearchType (String name){ this.name = name; }

    public String getName() { return name; }
}

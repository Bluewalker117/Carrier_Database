package RJN.Steel.Carrier.Database.models;

public enum SearchType {

  //  GENERAL ("Everything"),
    NAME ("Carrier Name");


    private final String name;

    SearchType (String name){ this.name = name; }

    public String getName() { return name; }
}

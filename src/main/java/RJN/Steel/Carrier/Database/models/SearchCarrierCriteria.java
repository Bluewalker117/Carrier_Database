package RJN.Steel.Carrier.Database.models;

public class SearchCarrierCriteria extends SearchResults{

    public enum CarrierSearchType{BY_NAME};

    private CarrierSearchType searchBy = CarrierSearchType.BY_NAME;
    private String carrierName;
    private int id;

    public CarrierSearchType getSearchBy(){
        return searchBy;
    }

    public void setSearchBy(CarrierSearchType searchBy) {
        this.searchBy = searchBy;
    }

    public String getCarrierName(){
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

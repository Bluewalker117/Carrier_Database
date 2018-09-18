package RJN.Steel.Carrier.Database.models.Forms;

import RJN.Steel.Carrier.Database.models.Carrier;
import RJN.Steel.Carrier.Database.models.SearchType;

import java.util.List;

public class SearchForm {

    private SearchType[] types = SearchType.values();

    private SearchType searchType = SearchType.GENERAL;

    private String keyword;

    private List<Carrier> carriers;

    public SearchType getSearchType() { return searchType; }

    public void setTypes(SearchType[] types) { this.types = types; }

    public SearchType[] getTypes() { return types; }

    public String getKeyword() { return keyword; }

    public void setKeyword(String keyword) { this.keyword = keyword; }

    public List<Carrier> getCarriers() {
        return carriers;
    }

    public void setCarriers(List<Carrier> carriers) {
        this.carriers = carriers;
    }
}

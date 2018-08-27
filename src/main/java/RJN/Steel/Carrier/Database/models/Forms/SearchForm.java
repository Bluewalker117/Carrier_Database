package RJN.Steel.Carrier.Database.models.Forms;

import RJN.Steel.Carrier.Database.models.SearchType;

public class SearchForm {

    private SearchType[] types = SearchType.values();

    private SearchType searchType = SearchType.GENERAL;

    private String keyword;

    public SearchType getSearchType() { return searchType; }

    public void setTypes(SearchType[] types) { this.types = types; }

    public SearchType[] getTypes() { return types; }

    public String getKeyword() { return keyword; }

    public void setKeyword(String keyword) { this.keyword = keyword; }
}

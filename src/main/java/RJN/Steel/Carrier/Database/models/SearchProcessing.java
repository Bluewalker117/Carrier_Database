package RJN.Steel.Carrier.Database.models;

import RJN.Steel.Carrier.Database.CarrierDatabaseApplication;
import RJN.Steel.Carrier.Database.models.Data.CarrierDao;
import RJN.Steel.Carrier.Database.models.Data.SearchDao;

import java.util.List;

public class SearchProcessing {

    public SearchResults<Carrier> search(SearchCarrierCriteria searchCriteria){

        SearchCarrierCriteria.CarrierSearchType searchType = searchCriteria.getSearchBy();
        List<Carrier> results = null;
        if(searchType== SearchCarrierCriteria.CarrierSearchType.BY_NAME) {

        }

        SearchResultsCarrier<Carrier> searchResults = new SearchResultsCarrier<Carrier>();
        searchResults.setResults(results);



    }


}

package RJN.Steel.Carrier.Database.models;

import java.util.ArrayList;
import java.util.List;

public abstract class SearchResults<T> {

    private List<T> results = null;

    public List<T> getResults() {

        return results;
    }

    public void setResults(List<T> aresult) {
        if (aresult == null){
            aresult = new ArrayList<>();
        }
        this.results = aresult;
        }
    }


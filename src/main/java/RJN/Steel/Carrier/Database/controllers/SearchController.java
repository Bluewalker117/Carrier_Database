package RJN.Steel.Carrier.Database.controllers;

import RJN.Steel.Carrier.Database.models.CarrierSearch;
import RJN.Steel.Carrier.Database.models.Data.CarrierDao;
import RJN.Steel.Carrier.Database.models.Forms.SearchForm;
import RJN.Steel.Carrier.Database.models.SearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("carrier/search")
public class SearchController {

    @Autowired
    private CarrierDao searchDao;

    @Autowired
    private CarrierSearch carrierSearch;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, SearchType searchType){

        model.addAttribute("title", "Search Database");
        model.addAttribute("subtitle", "Search Results:");
        //model.addAttribute("types", searchType.);
        model.addAttribute(new SearchForm());
        return "search/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processSearch(@RequestParam("searchInput") String searchTerm, Model model){

        List searchResults = null;

        try {
            searchResults = carrierSearch.search(searchTerm);

        } catch (Exception ex){

        }

        if (searchResults == null){

            model.addAttribute("title", "Search Database");
            model.addAttribute("subtitle", "Search Results");
            model.addAttribute("carriers","");
            return "search/index";

        } else {

            model.addAttribute("title", "Search Database");
            model.addAttribute("subtitle", "Search Results");
            model.addAttribute("carriers", searchResults);

        }

        return "search/index";



    }

}

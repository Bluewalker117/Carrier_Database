package RJN.Steel.Carrier.Database.controllers;

import RJN.Steel.Carrier.Database.models.Carrier;
import RJN.Steel.Carrier.Database.models.CarrierSearch;
import RJN.Steel.Carrier.Database.models.Data.CarrierDao;
import RJN.Steel.Carrier.Database.models.Data.SearchDao;
import RJN.Steel.Carrier.Database.models.Forms.SearchForm;
import RJN.Steel.Carrier.Database.models.SearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("carrier/search")
public class SearchController {

    @Autowired
    private CarrierDao searchDao;

    @Autowired
    private CarrierSearch carrierSearch;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){

        model.addAttribute("title", "Search Carrier Database");
        model.addAttribute("title2", "Search Results");
        model.addAttribute(new SearchForm());
        System.out.println("Get works");

        return "search/index";
    }

    @RequestMapping(value = "results")
    public String processSearch(@RequestParam("searchInput") String searchTerm, Model model){
        System.out.println("1");
        List searchResults = null;
        try {
            searchResults = carrierSearch.search(searchTerm);
        } catch (Exception ex) {

        }

        System.out.println(searchTerm);
        System.out.println("2");
        searchDao.findByName(searchTerm);
        model.addAttribute("title", "Search Carrier Database");
        model.addAttribute("title2", "Search Results");
        model.addAttribute("carriers",searchResults);


      return "search/index";
    }
//"view/{carrierId}/edit"
}

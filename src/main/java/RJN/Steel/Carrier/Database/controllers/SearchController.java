package RJN.Steel.Carrier.Database.controllers;

import RJN.Steel.Carrier.Database.models.Carrier;
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

import java.util.List;

@Controller
@RequestMapping(value = "carrier/search")
public class SearchController {

    @Autowired
    private SearchDao searchDao;

    @Autowired
    private CarrierDao carrierDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displaySearchForm(Model model){

        model.addAttribute("title", "Search Carrier Database");
        model.addAttribute(new SearchForm());
        System.out.println("Get");
        return "search/searchindex";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String returnSearchResults(@RequestParam("keyword") String keyword, @ModelAttribute SearchForm searchForm, Model model){

        List<Carrier> scarrier = searchDao.findByName(searchForm.getKeyword());
        System.out.println("1");


        model.addAttribute("title", "Search Results:");
        model.addAttribute("carriers", scarrier);
        System.out.println("2");

        return "search/displayresults";
    }
//return address does not match what shows up in browser
}

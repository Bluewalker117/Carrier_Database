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

import java.util.ArrayList;

@Controller
@RequestMapping("carrier/search")
public class SearchController {

    @Autowired
    private CarrierDao searchDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){

        model.addAttribute("title", "Search Carrier Database");
        model.addAttribute(new SearchForm());
        return "search/index";
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String processSearch(Model model, @ModelAttribute SearchForm searchForm){

      return "yes";
    }

}

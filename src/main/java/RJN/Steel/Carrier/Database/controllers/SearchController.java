package RJN.Steel.Carrier.Database.controllers;

import RJN.Steel.Carrier.Database.models.Data.SearchDao;
import RJN.Steel.Carrier.Database.models.Forms.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("carrier/search")
public class SearchController {

    @Autowired
    private SearchDao searchDao;

    @RequestMapping("")
    public String index(Model model){

        model.addAttribute("title", "Search Carrier Database");
        model.addAttribute(new SearchForm());
        return "search/index";
    }
}

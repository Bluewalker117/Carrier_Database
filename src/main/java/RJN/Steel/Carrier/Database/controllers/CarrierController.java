package RJN.Steel.Carrier.Database.controllers;

import RJN.Steel.Carrier.Database.models.Carrier;
//import RJN.Steel.Carrier.Database.models.Data.CarrierDao; //TODO have DAO work
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("carrier")
public class CarrierController {

    @RequestMapping("")
    public String index(Model model){

        model.addAttribute("title", "Insurance Carrier Database");
        return "carrier/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addcarrier (Model model){
        model.addAttribute(new Carrier());
        model.addAttribute("title", "Add a Carrier");
        return "carrier/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addcarrier (@ModelAttribute @Valid Carrier carrier, Model model, Errors errors){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add a Carrier");
            return "carrier/add";
        }

       // carrierDao.save(carrier);
        return "redirect";
    }




}


//TODO set up database
//TODO have add, remove, edit functions for database
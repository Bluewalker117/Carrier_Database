package RJN.Steel.Carrier.Database.controllers;

import RJN.Steel.Carrier.Database.models.Carrier;
import RJN.Steel.Carrier.Database.models.Data.CarrierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("carrier")
public class CarrierController {

    @Autowired
    private CarrierDao carrierDao;

    @RequestMapping("")
    public String index(Model model){

        model.addAttribute("title", "Insurance Carrier Database");
        model.addAttribute("carriers", carrierDao.findAll());
        return "carrier/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addCarrierDisplay (Model model){
        model.addAttribute(new Carrier());
        model.addAttribute("title", "Add a Carrier");
        return "carrier/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addCarrierProcess (@ModelAttribute @Valid Carrier carrier, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add a Carrier");

            return "carrier/add";
        }

        carrierDao.save(carrier);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String removeCarrierDisplay (Model model){
        model.addAttribute("title", "Remove a Carrier");
        model.addAttribute("carriers", carrierDao.findAll());
        return "carrier/edit";

    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCarrierProcess (@RequestParam int[] carrierIds){
        for (int carrierId : carrierIds){
            carrierDao.deleteById(carrierId);
        }
        return "redirect:";

    }




}



//TODO have edit functions for database
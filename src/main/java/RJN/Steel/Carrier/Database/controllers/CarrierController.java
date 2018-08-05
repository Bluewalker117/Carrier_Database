package RJN.Steel.Carrier.Database.controllers;

import RJN.Steel.Carrier.Database.models.Carrier;
import RJN.Steel.Carrier.Database.models.Data.CarrierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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
        return "carrier/remove";

    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCarrierProcess (@RequestParam int[] carrierIds){
        for (int carrierId : carrierIds){
            carrierDao.deleteById(carrierId);
        }
        return "redirect:";

    }

    @RequestMapping(value = "edit/{carrierId}", method = RequestMethod.GET)
    public String editCarrierDisplay (Model model, @PathVariable int carrierId){
        Carrier forEditing = carrierDao.findById(carrierId).get();
        model.addAttribute("title", "Edit Carrier: " + forEditing.getName());
        model.addAttribute("name", forEditing.getName());
        //model.addAttribute("address", forEditing.getAddress());
        return "carrier/edit";

    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String editCarrierProcess (int carrierId, String name){
        //model.addAttribute("title", "Edit a Carrier");
        return "Under development";
    }





}



//TODO have edit functions for database
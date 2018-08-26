package RJN.Steel.Carrier.Database.controllers;

import RJN.Steel.Carrier.Database.models.Carrier;
import RJN.Steel.Carrier.Database.models.Data.CarrierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @RequestMapping(value = "view/{carrierId}", method = RequestMethod.GET)
    public String detailedCarrierDisplay (Model model, @PathVariable int carrierId){
        Carrier forEditing = carrierDao.findById(carrierId).get();
        model.addAttribute("title", "Carrier: " + forEditing.getName());
        model.addAttribute("single", carrierId);
        model.addAttribute("name", forEditing.getName());
        model.addAttribute("addressEmailGeneral", forEditing.getAddressEmailGeneral());
        model.addAttribute("addressEmailPattern", forEditing.getAddressEmailPattern());
        model.addAttribute("phoneNumber", forEditing.getPhoneNumber());
        model.addAttribute("claimNumber", forEditing.getClaimNumber());
        model.addAttribute("policyNumber", forEditing.getPolicyNumber());
        model.addAttribute("memberOfHub", forEditing.getMemberOfHub());
        model.addAttribute("memberOfArb", forEditing.getMemberOfArb());
        model.addAttribute("navigatorId", forEditing.getNavigatorId());
        return "carrier/detail";

    }

    @RequestMapping(value = "view/{carrierId}/edit", method = RequestMethod.GET)
    public String editCarrierView (Model model, @PathVariable int carrierId) {
        System.out.println("HELLO WORLD");
        Carrier forEditing = carrierDao.findById(carrierId).get();
        model.addAttribute("title", "Edit Carrier: " + forEditing.getName());
        model.addAttribute("name", forEditing.getName());
        model.addAttribute("addressEmailGeneral", forEditing.getAddressEmailGeneral());
        model.addAttribute("addressEmailPattern", forEditing.getAddressEmailPattern());
        model.addAttribute("phoneNumber", forEditing.getPhoneNumber());
        model.addAttribute("claimNumber", forEditing.getClaimNumber());
        model.addAttribute("policyNumber", forEditing.getPolicyNumber());
        model.addAttribute("memberOfHub", forEditing.getMemberOfHub());
        model.addAttribute("memberOfArb", forEditing.getMemberOfArb());
        model.addAttribute("navigatorId", forEditing.getNavigatorId());
        return "carrier/edit";
    }


    @RequestMapping(value = "view/{carrierId}/edit", method = RequestMethod.PUT)
    public String editCarrierProcess (@RequestBody Carrier carrier, @PathVariable int carrierId) {

        System.out.println("1");
        Carrier singleCarrier = carrier;
        System.out.println("2");
        Carrier existingCarrier = carrierDao.findById(carrierId).get();
        System.out.println("3");
        existingCarrier.setName(singleCarrier.getName());

        System.out.println("4");
        carrierDao.save(existingCarrier);

        //Carrier change = carrierDao.findById(carrierId).get();
        //model.addAttribute("name", name);
        //change.setName(name);
        //carrierDao.save(change);
        System.out.println("5");
        return "/carrier/detail";
        //returns the error, "Parameter conditions "name" not met for actual request parameters: carrierId={}"
    }





}



//TODO have edit functions for database
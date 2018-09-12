package RJN.Steel.Carrier.Database.controllers;

import RJN.Steel.Carrier.Database.models.Carrier;
import RJN.Steel.Carrier.Database.models.Data.CarrierDao;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;




import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("carrier")
public class CarrierController {

    @Autowired
    private CarrierDao carrierDao;

    @RequestMapping("")
    public String index(Model model){

        //Sort list = new Sort(Sort.Direction.ASC, "name");
        model.addAttribute("title", "Insurance Carrier Database");
        model.addAttribute("carriers", carrierDao.findAll());
        return "carrier/index";

        //TODO display results alphabetically by name. findall() into an array/list, then sort, then pass into model.addAttribute
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
        Carrier forEditing = carrierDao.findById(carrierId).get();
        model.addAttribute("title", "Edit Carrier: " + forEditing.getName());
        model.addAttribute("id", carrierId);
        model.addAttribute("name", forEditing.getName());
        model.addAttribute("addressEmailGeneral", forEditing.getAddressEmailGeneral());
        model.addAttribute("addressEmailPattern", forEditing.getAddressEmailPattern());
        model.addAttribute("phoneNumber", forEditing.getPhoneNumber());
        model.addAttribute("claimNumber", forEditing.getClaimNumber());
        model.addAttribute("policyNumber", forEditing.getPolicyNumber());
        model.addAttribute("memberOfHub", forEditing.getMemberOfHub());
        model.addAttribute("memberOfArb", forEditing.getMemberOfArb());
        model.addAttribute("navigatorId", forEditing.getNavigatorId());
        model.addAttribute("temp", forEditing);
        return "carrier/edit";
    }


    @RequestMapping(value = "view/{carrierId}/edit", method = RequestMethod.POST)
    public String editCarrierProcess (@PathVariable int carrierId, @ModelAttribute("temp") @Valid Carrier temp, Errors errors, Model model) {

        Carrier existing = carrierDao.findById(carrierId).get();

        if (errors.hasErrors()){
            model.addAttribute("title", "Edit Carrier: " + existing.getName());

            return "carrier/edit";
        }


        existing.setName(temp.getName());
        existing.setAddressEmailGeneral(temp.getAddressEmailGeneral());
        existing.setAddressEmailPattern(temp.getAddressEmailPattern());
        existing.setPhoneNumber(temp.getPhoneNumber());
        existing.setClaimNumber(temp.getClaimNumber());
        existing.setPolicyNumber(temp.getPolicyNumber());
        existing.setMemberOfHub(temp.getMemberOfHub());
        existing.setMemberOfArb(temp.getMemberOfArb());
        existing.setNavigatorId(temp.getNavigatorId());

        carrierDao.save(existing);

        return "redirect:";

    }





}




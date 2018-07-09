package RJN.Steel.Carrier.Database.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("carrier")
public class CarrierController {

    @RequestMapping("")
    public String index(Model model){
        return "carrier/index";
    }
}

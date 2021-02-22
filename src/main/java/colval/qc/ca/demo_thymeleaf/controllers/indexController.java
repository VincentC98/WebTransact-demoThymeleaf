package colval.qc.ca.demo_thymeleaf.controllers;

import colval.qc.ca.demo_thymeleaf.services.impl.CustomerService;
import colval.qc.ca.demo_thymeleaf.services.interfaces.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    CustomerService customerService;

    public indexController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/") //@GetMapping source de fichiers == ressources/templates
    public String index(Model model) {
        //compter les customers
        model.addAttribute("nbCustomer", customerService.countAllCustomer()); //addAttribute(variable name, objectToBind)
        return "index/index"; //folder/file
    }


}

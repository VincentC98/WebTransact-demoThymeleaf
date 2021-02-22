package colval.qc.ca.demo_thymeleaf.controllers;

import colval.qc.ca.demo_thymeleaf.services.impl.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class customerController {
    CustomerService customerService;

    public customerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public String customer(Model model){
        model.addAttribute("allCustomer", customerService.findAllCustomerIdDescAndLimitTen());
        return "customer/customer";
    }
}

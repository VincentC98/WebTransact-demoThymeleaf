package colval.qc.ca.demo_thymeleaf.controllers;

import colval.qc.ca.demo_thymeleaf.controllers.viewmodels.SearchNamesVM;
import colval.qc.ca.demo_thymeleaf.model.enitties.Customer;
import colval.qc.ca.demo_thymeleaf.services.impl.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class customerController {
    CustomerService customerService;

    public customerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public String customer(Model model){
        model.addAttribute("searchNames", new SearchNamesVM());
        model.addAttribute("allCustomer", customerService.findAllCustomerIdDescAndLimitTen());
        model.addAttribute("nbCustomer", customerService.countAllCustomer());
        return "customer/customers";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateView(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("customer/updateCustomer");
        Optional<Customer> getCustomer = customerService.readOne(id);
        Customer customer = null;
        if (getCustomer.isPresent()){
            customer = getCustomer.get();
        }
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping(value="/update/{id}")
    public String updateCustomer(@PathVariable Long id,@ModelAttribute("customer") Customer customer){
        customerService.updateFirstNameAndLastName(id, customer.getFirstName(), customer.getLastName());
        return "redirect:/customer/showCustomer/" + id;
    }

    @GetMapping("/showCustomer/{id}")
    public String getcustomer(@PathVariable Long id,Model model){
        Optional<Customer> customer = customerService.readOne(id);
        String firstName = customer.map(Customer::getFirstName).orElse("");
        String lastName = customer.map(Customer::getLastName).orElse("");
        String email = customer.map(Customer::getEmail).orElse("");
        model.addAttribute("getFirstName", firstName);
        model.addAttribute("getLastName", lastName);
        model.addAttribute("getEmail", email);
        return "customer/customer";
    }

    @PostMapping("/doSearchNames")
    public String searchCustomersByName(Model model, SearchNamesVM searchNamesVM){
        System.out.println(searchNamesVM.getFirstname());
        List<Customer> customers = customerService.getAllCustomerWithFirstNameSubStr(searchNamesVM.getFirstname());
        int nbCustomer = customers.size();
        System.out.println(nbCustomer);
        model.addAttribute("searchNames", new SearchNamesVM());
        model.addAttribute("allCustomer", customers);
        model.addAttribute("nbCustomer", nbCustomer);
        return "customer/customers";
    }

    @GetMapping("/{id}")
    public String getCountry(Model model, @PathVariable Long id){

        Optional<Customer> customer=customerService.readOne(id);

        model.addAttribute("customer", customer.get());

        return "customer/detail";

    }

}

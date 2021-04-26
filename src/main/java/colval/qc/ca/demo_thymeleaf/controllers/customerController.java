package colval.qc.ca.demo_thymeleaf.controllers;

import colval.qc.ca.demo_thymeleaf.controllers.viewmodels.SearchNamesVM;
import colval.qc.ca.demo_thymeleaf.model.enitties.Address;
import colval.qc.ca.demo_thymeleaf.model.enitties.Customer;
import colval.qc.ca.demo_thymeleaf.model.enitties.Store;
import colval.qc.ca.demo_thymeleaf.services.impl.AddressService;
import colval.qc.ca.demo_thymeleaf.services.impl.CustomerService;
import colval.qc.ca.demo_thymeleaf.services.impl.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import colval.qc.ca.demo_thymeleaf.model.DTO.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class customerController {
    CustomerService customerService;
    private AddressService addressService;
    private StoreService storeService;
    private String varSearch;

    public customerController(CustomerService customerService, AddressService addressService, StoreService storeService) {
        this.customerService = customerService;
        this.addressService = addressService;
        this.storeService = storeService;
    }

    @GetMapping
    public String customer(Model model){
        /*model.addAttribute("searchNames", new SearchNamesVM());
        model.addAttribute("allCustomer", customerService.findAllCustomerIdDescAndLimitTen());
        model.addAttribute("nbCustomer", customerService.countAllCustomer());
        return "customer/customers";*/
        if (varSearch != null && !varSearch.isEmpty()) {
            List<Customer> customers = customerService.getAllCustomerWithFirstNameSubStr(varSearch);
            model.addAttribute("nbCustomer", customers.size());
            model.addAttribute("allCustomer", customers);
            model.addAttribute("searchNames", new SearchNamesVM(varSearch));
            varSearch = null;
        } else {
            model.addAttribute("allCustomer", customerService.findAllCustomerIdDescAndLimitTen());
            model.addAttribute("nbCustomer", customerService.countAllCustomer());
            model.addAttribute("searchNames", new SearchNamesVM());
        }

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
        /*System.out.println(searchNamesVM.getFirstname());
        List<Customer> customers = customerService.getAllCustomerWithFirstNameSubStr(searchNamesVM.getFirstname());
        int nbCustomer = customers.size();
        System.out.println(nbCustomer);
        model.addAttribute("searchNames", new SearchNamesVM());
        model.addAttribute("allCustomer", customers);
        model.addAttribute("nbCustomer", nbCustomer);*/
        varSearch = searchNamesVM.getFirstname();

        return "redirect:/customer";

    }

    @GetMapping("/add")
    public String addCustomerView(Model model){
        return "customer/customerAdd";
    }

    @GetMapping("/{id}")
    public String getCountry(Model model, @PathVariable Long id){

        Optional<Customer> customer=customerService.readOne(id);

        model.addAttribute("customer", customer.get());

        return "customer/customer";

    }

    @GetMapping("/new")
    public String showAddForms(Model model) {
        List<Address> addresses = addressService.readAll();
        List<Store> stores = storeService.readAll();
        model.addAttribute("customer", new CustomerDTO());
        model.addAttribute("addresses", addresses);
        model.addAttribute("stores", stores);

        return "customer/add";

        //return "customer/addcustomer";
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid CustomerDTO customerDTO) {
        Customer customer;
        Optional<Address> address = addressService.readOne(customerDTO.getAddressId());
        if (customerDTO.getCustomerId() != null) {
            customer = customerService.readOne(customerDTO.getCustomerId()).orElseThrow(() -> new IllegalArgumentException("Customer Id not found"));
            customer.setCustomerId(customerDTO.getCustomerId());
        } else {
            //recuperation du premier store
            Store store = storeService.readAll().stream().findFirst().orElse(null);
            customer = new Customer();
            customer.setStore(store);
        }
        if (customerDTO.getCreateDate() != null) customer.setCreateDate(customerDTO.getCreateDate());
        customer.setActive(customerDTO.isActive());
        customer.setEmail(customerDTO.getEmail());
        customer.setLastName(customerDTO.getLastName());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastUpdate(customerDTO.getCreateDate());
        customer.setAddress(address.orElseThrow(null));

        customerService.create(customer);

        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable long id){
        customerService.delete(id);
        System.out.println("Client #" + id + " supprimé!");
        return "redirect:/customer";
    }


}

package colval.qc.ca.demo_thymeleaf.services.impl;

import colval.qc.ca.demo_thymeleaf.model.DTO.CustomerDTO;
import colval.qc.ca.demo_thymeleaf.model.enitties.Address;
import colval.qc.ca.demo_thymeleaf.model.enitties.Customer;
import colval.qc.ca.demo_thymeleaf.model.enitties.Store;
import colval.qc.ca.demo_thymeleaf.repositories.CustomerRepository;
import colval.qc.ca.demo_thymeleaf.services.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;
    private final AddressService addressService;
    private final StoreService storeService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, AddressService addressService, StoreService storeService) {
        this.customerRepository = customerRepository;
        this.addressService = addressService;
        this.storeService = storeService;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer create(CustomerDTO customer) {

        Date now = new Date();

        Address address = addressService.readOne(customer.getAddressId()).get();
        Store store = storeService.readAll().stream().findFirst().get();

        Customer newCustomer = new Customer();
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setActive(customer.isActive());
        newCustomer.setCreateDate(now);
        newCustomer.setLastUpdate(now);
        newCustomer.setAddress(address);
        newCustomer.setStore(store);

        return customerRepository.save(newCustomer);

    }

    @Override
    public void update(CustomerDTO customer) {
        Optional<Customer> storedOptional = readOne(customer.getCustomerId());

        if (storedOptional.isPresent()) {
            Customer stored = storedOptional.get();

            Date now = new Date();

            Address address = addressService.readOne(customer.getAddressId()).get();
            Store store = storeService.readAll().stream().findFirst().get();

            stored.setFirstName(customer.getFirstName());
            stored.setLastName(customer.getLastName());
            stored.setEmail(customer.getEmail());
            stored.setActive(customer.isActive());
            stored.setLastUpdate(now);
            stored.setAddress(address);
            stored.setStore(store);

            customerRepository.save(stored);
        }

    }

    @Override
    public Optional<Customer> readOne(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> readAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomerSortedByLastName() {
        return customerRepository.findAllCustomerSortedByLastName();
    }

    @Override
    public Customer updateFirstNameAndLastName(Long customerId, String firstName, String lastName) {
        Optional<Customer> customerRecover = this.readOne(customerId);
        if (customerRecover.isEmpty()) throw new RuntimeException("Customer Id not found");
        Customer customer = customerRecover.get();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customerRepository.save(customer);
    }

    @Override
    public Long countAllCustomer() {
        return customerRepository.count();
    }

    @Override
    public List<Customer> findAllCustomerIdDescAndLimitTen() {
        return customerRepository.findAllCustomerIdDesc().stream().limit(10).collect(Collectors.toList());
    }

    @Override
    public List<Customer> getAllCustomerWithFirstNameSubStr(String subStr) {
        return customerRepository.findByFirstNameSubStr(subStr);
    }


}

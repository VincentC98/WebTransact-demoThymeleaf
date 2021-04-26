package colval.qc.ca.demo_thymeleaf.web.rest;

import colval.qc.ca.demo_thymeleaf.model.DTO.CustomerDTO;
import colval.qc.ca.demo_thymeleaf.model.DTO.UserDto;
import colval.qc.ca.demo_thymeleaf.model.enitties.Customer;
import colval.qc.ca.demo_thymeleaf.services.impl.CustomerService;
import colval.qc.ca.demo_thymeleaf.services.mappers.CustomerMapper;
import colval.qc.ca.demo_thymeleaf.services.mappers.EntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer")
public class CustomerResource {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);


    public CustomerResource(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping
    public List<CustomerDTO> getAll() {
        return this.customerService.readAll().stream()
                .map(customerMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCustomerwithId(@PathVariable Long id) {
        Optional<Customer> customer = customerService.readOne(id);
        Optional<CustomerDTO> customerDTO = customer.stream()
                .map(customerMapper::entityToDto)
                .findFirst();
        return customerDTO.isPresent() ? new ResponseEntity<>(customerDTO.get()
                , HttpStatus.OK) : new ResponseEntity<>("Customer Id not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{searchQuery}")
    public ResponseEntity<Collection<CustomerDTO>> getBySearch(@PathVariable String searchQuery) {
        return ResponseEntity.ok(this.customerService.getAllCustomerWithFirstNameSubStr(searchQuery).stream()
                .map(customerMapper::entityToDto)
                .collect(Collectors.toList()));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> save(@RequestBody @Valid CustomerDTO customer) {
        Customer saved = this.customerService.create(customer);
        return ResponseEntity.created(URI.create(saved.toString())).build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody @Valid CustomerDTO customer) {
        this.customerService.update(customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUser(@PathVariable Integer id) {
        try {
            String url = "https://reqres.in/api/users/" + id;
            RestTemplate restTemplate = new RestTemplate();
            UserDto user = restTemplate.getForObject(url, UserDto.class);
            return ResponseEntity.ok(user);
        } catch (HttpClientErrorException e) {
            log.error("Error {}", e.getLocalizedMessage(), e);
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
package colval.qc.ca.demo_thymeleaf.services.interfaces;

import colval.qc.ca.demo_thymeleaf.model.DTO.CustomerDTO;
import colval.qc.ca.demo_thymeleaf.model.enitties.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Customer create(Customer customer);

    Customer create(CustomerDTO customer);

    void update(CustomerDTO customer);

    Optional<Customer> readOne(Long id);

    List<Customer> readAll();

    void delete(Long id);

    List<Customer> getAllCustomerSortedByLastName();

    Customer updateFirstNameAndLastName(Long customerId,String firstName,String lastName);

    Long countAllCustomer();

    List<Customer> findAllCustomerIdDescAndLimitTen();

    List<Customer> getAllCustomerWithFirstNameSubStr(String subStr);

}

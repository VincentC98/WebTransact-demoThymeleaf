package colval.qc.ca.demo_thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import colval.qc.ca.demo_thymeleaf.model.enitties.Customer;

import java.sql.Timestamp;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllCustomerSortedByLastName();
    Customer findCustomerByCreateDate(Timestamp createDate);
    List<Customer> findCustomersByFirstNameSubStr(String firstNameSubStr);
    List<Customer> findAllCustomerIdDesc();
}

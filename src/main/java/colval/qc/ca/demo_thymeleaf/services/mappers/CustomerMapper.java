package colval.qc.ca.demo_thymeleaf.services.mappers;

import colval.qc.ca.demo_thymeleaf.model.DTO.CustomerDTO;
import colval.qc.ca.demo_thymeleaf.model.enitties.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper implements EntityMapper<Customer, CustomerDTO> {
    @Override
    public CustomerDTO entityToDto(Customer customer) {
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getActive(),
                customer.getCreateDate(),
                customer.getLastUpdate(),
                customer.getAddress().getAddressId(),
                customer.getStore().getStoreId()
        );
    }
}

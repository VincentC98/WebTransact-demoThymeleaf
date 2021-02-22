package colval.qc.ca.demo_thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import colval.qc.ca.demo_thymeleaf.model.enitties.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findAddressByPostalCode(String postalCode);
    Address findAddressByPhone(String phone);
}

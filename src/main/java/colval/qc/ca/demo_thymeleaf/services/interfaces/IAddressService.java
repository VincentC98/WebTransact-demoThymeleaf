package colval.qc.ca.demo_thymeleaf.services.interfaces;

import colval.qc.ca.demo_thymeleaf.model.enitties.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressService {
    Address create(Address address);

    Optional<Address> readOne(Long addressId);
    List<Address> readAll();
    void delete(Long addressId);
}

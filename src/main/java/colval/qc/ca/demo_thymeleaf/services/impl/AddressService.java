package colval.qc.ca.demo_thymeleaf.services.impl;

import colval.qc.ca.demo_thymeleaf.model.enitties.Address;
import colval.qc.ca.demo_thymeleaf.repositories.AddressRepository;
import colval.qc.ca.demo_thymeleaf.services.interfaces.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> readOne(Long addressId) {
        return addressRepository.findById(addressId);
    }

    @Override
    public List<Address> readAll() {
        return addressRepository.findAll();
    }

    @Override
    public void delete(Long addressId) {
        addressRepository.deleteById(addressId);
    }

}

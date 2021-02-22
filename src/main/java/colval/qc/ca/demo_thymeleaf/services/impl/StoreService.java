package colval.qc.ca.demo_thymeleaf.services.impl;

import colval.qc.ca.demo_thymeleaf.model.enitties.Store;
import colval.qc.ca.demo_thymeleaf.services.interfaces.IStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService implements IStoreService {
    @Override
    public Store create(Store store) {
        return null;
    }

    @Override
    public Optional<Store> readOne(Long storeId) {
        return Optional.empty();
    }

    @Override
    public List<Store> readAll() {
        return null;
    }

    @Override
    public void delete(Long storeId) {

    }
}

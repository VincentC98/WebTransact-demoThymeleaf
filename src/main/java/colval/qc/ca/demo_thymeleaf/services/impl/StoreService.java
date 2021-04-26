package colval.qc.ca.demo_thymeleaf.services.impl;

import colval.qc.ca.demo_thymeleaf.model.enitties.Store;
import colval.qc.ca.demo_thymeleaf.repositories.StoreRepository;
import colval.qc.ca.demo_thymeleaf.services.interfaces.IStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService implements IStoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

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
        return storeRepository.findAll();
    }

    @Override
    public void delete(Long storeId) {

    }
}

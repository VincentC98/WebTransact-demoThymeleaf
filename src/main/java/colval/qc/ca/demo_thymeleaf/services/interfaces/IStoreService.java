package colval.qc.ca.demo_thymeleaf.services.interfaces;

import colval.qc.ca.demo_thymeleaf.model.enitties.Staff;
import colval.qc.ca.demo_thymeleaf.model.enitties.Store;

import java.util.List;
import java.util.Optional;

public interface IStoreService {
    Store create(Store store);

    Optional<Store> readOne(Long storeId);

    List<Store> readAll();

    void delete(Long storeId);
}

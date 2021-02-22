package colval.qc.ca.demo_thymeleaf.services.interfaces;

import colval.qc.ca.demo_thymeleaf.model.enitties.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    City create(City city);

    Optional<City> readOne(Long cityId);

    List<City> readAll();

    void delete(Long cityId);

    Long countAllCity();

    List<City> getAllTenRandomCity();

}

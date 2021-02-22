package colval.qc.ca.demo_thymeleaf.repositories;

import colval.qc.ca.demo_thymeleaf.model.enitties.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

}

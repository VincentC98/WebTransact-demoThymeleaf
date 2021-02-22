package colval.qc.ca.demo_thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import colval.qc.ca.demo_thymeleaf.model.enitties.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findCountryByCountry(String country);

}

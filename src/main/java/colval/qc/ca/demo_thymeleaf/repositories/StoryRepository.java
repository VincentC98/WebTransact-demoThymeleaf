package colval.qc.ca.demo_thymeleaf.repositories;

import colval.qc.ca.demo_thymeleaf.model.enitties.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Store, Long> {
}

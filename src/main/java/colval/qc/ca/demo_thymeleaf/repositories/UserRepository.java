package colval.qc.ca.demo_thymeleaf.repositories;

import colval.qc.ca.demo_thymeleaf.model.enitties.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByUsername(String username);

}


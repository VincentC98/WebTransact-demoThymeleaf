package colval.qc.ca.demo_thymeleaf.repositories;

import colval.qc.ca.demo_thymeleaf.model.enitties.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    Optional<Actor> findByActorId(Long actorId);

    List<Actor> getActorByFirstName(String firstName);

    List<Actor> getActorByLastName(String lastName);

    List<Actor> getActorByLastUpdate(Date lastUpdate);

    Long countAll();

    List<Actor> findAllActorIdAsc();
}

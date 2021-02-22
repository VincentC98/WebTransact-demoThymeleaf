package colval.qc.ca.demo_thymeleaf.services.impl;

import colval.qc.ca.demo_thymeleaf.model.enitties.Actor;
import colval.qc.ca.demo_thymeleaf.repositories.ActorRepository;
import colval.qc.ca.demo_thymeleaf.services.interfaces.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Optional<Actor> readOne(Long actorId) {
        return actorRepository.findByActorId(actorId);
    }

    @Override
    public List<Actor> readAll() {
        return actorRepository.findAll();
    }

    @Override
    public void delete(Long actorId) {
        actorRepository.deleteById(actorId);
    }

    @Override
    public List<Actor> getActorByFirstName(String firstName) {
        return actorRepository.getActorByFirstName(firstName);
    }

    @Override
    public List<Actor> getActorByLastName(String lastName) {
        return actorRepository.getActorByLastName(lastName);
    }

    @Override
    public List<Actor> getActorByLastUpdate(Date lastUpdate) {
        return actorRepository.getActorByLastUpdate(lastUpdate);
    }

    @Override
    public Long countAllActor() {
        return actorRepository.countAll();
    }

    @Override
    public List<Actor> findAllActorIdAscAndLimitTen() {
        return actorRepository.findAllActorIdAsc()
                .stream()
                .limit(10)
                .collect(Collectors.toList());
    }
}

package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{
    private ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }


    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Optional<Actor> getActorById(Long id) {
        return actorRepository.findById(id);
    }

    @Override
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public void deleteActor(Long id) {
    actorRepository.deleteById(id);
    }

    @Override
    public Actor updateActor(Long id, Actor newActor) {
        Optional<Actor> existingActorOptional = actorRepository.findById(id);

        existingActorOptional.isPresent();
        Actor existingActor = existingActorOptional.get();

        existingActor.setFirstName(newActor.getFirstName());
        existingActor.setLastName(newActor.getLastName());
        existingActor.setGender(newActor.getGender());
        existingActor.setBirthDate(newActor.getBirthDate());
        existingActor.setMovies(newActor.getMovies());

        return actorRepository.save(existingActor);
    }
}

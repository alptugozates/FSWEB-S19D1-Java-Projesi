package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface ActorService {
    List<Actor> getAllActors();
    Optional<Actor> getActorById(Long id);
    Actor saveActor(Actor actor);
    void deleteActor(Long id);
    Actor updateActor(Long id, Actor newActor);
}

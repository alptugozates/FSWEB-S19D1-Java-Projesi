package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/actors")
public class ActorController {
    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }
    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }
    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable Long id){
        return actorService.getActorById(id).orElse(null);
    }
    @PostMapping
    public Actor saveActor(@RequestBody Actor actor){
        return actorService.saveActor(actor);
    }
    @PutMapping("/{id}")
    public Actor updateActor(@PathVariable Long id, @RequestBody Actor actor) {
        return actorService.updateActor(id, actor);
    }
    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable Long id){
        actorService.deleteActor(id);
    }

}

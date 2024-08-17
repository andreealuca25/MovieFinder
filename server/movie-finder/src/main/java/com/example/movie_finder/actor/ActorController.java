package com.example.movie_finder.actor;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.retrieveAllActors();
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @PostMapping("/add")
    public Actor addActor(@Valid @RequestBody Actor actor) {
        return actorService.addNewActor(actor);
    }

    @PutMapping("/update/{id}")
    public Actor updateActor(@PathVariable Long id, @Valid @RequestBody Actor updatedActor) {
        return actorService.updateActor(id, updatedActor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
    }
}

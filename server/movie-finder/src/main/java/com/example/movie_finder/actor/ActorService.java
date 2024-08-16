package com.example.movie_finder.actor;

import java.util.List;

public interface ActorService {
    List<Actor> retrieveAllActors();
    Actor getActorById(Long id);
    Actor addNewActor(Actor actor);
    Actor updateActor(Long id, Actor updatedActor);
    void deleteActor(Long id);
}

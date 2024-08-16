package com.example.movie_finder.actor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> retrieveAllActors() {
        return (List<Actor>) actorRepository.findAll();
    }

    @Override
    public Actor getActorById(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

    @Override
    public Actor addNewActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor updateActor(Long id, Actor updatedActor) {
        return actorRepository.findById(id).map(actor -> {
            actor.setFirstName(updatedActor.getFirstName());
            actor.setLastName(updatedActor.getLastName());
            actor.setDateOfBirth(updatedActor.getDateOfBirth());
            actor.setMovieList(updatedActor.getMovieList());
            actor.setTvSeriesList(updatedActor.getTvSeriesList());
            return actorRepository.save(actor);
        }).orElse(null);
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}

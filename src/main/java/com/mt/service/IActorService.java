package com.mt.service;

import java.util.List;
import java.util.Optional;

import com.mt.entity.Actor;
import com.mt.exception.ActorNotFoundException;

public interface IActorService {

	public String registerActor(Actor actor);
	public List<Actor> getAllActors();
	public Optional<Actor> getActorById(Integer id) throws ActorNotFoundException;
	public String deleteById(Integer id);
}

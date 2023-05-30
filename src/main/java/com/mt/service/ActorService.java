package com.mt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.entity.Actor;
import com.mt.exception.ActorNotFoundException;
import com.mt.repo.MyRepository;
@Service
public class ActorService implements IActorService {

	@Autowired
	MyRepository repo;

	@Override
	public String registerActor(Actor actor) {
		int id=repo.save(actor).getId();

		return id+" is saved successfully!!";
	}
	@Override
	public List<Actor> getAllActors() {
		List<Actor> list=repo.findAll();
		return list;
	}
	@Override
	public Optional<Actor> getActorById(Integer id)throws ActorNotFoundException{
		Optional<Actor> actor=repo.findById(id);

		return actor;
	}
	@Override
	public String deleteById(Integer id) {
		repo.deleteById(id);
		return id+" Deleted successfully";
	}
	
} 

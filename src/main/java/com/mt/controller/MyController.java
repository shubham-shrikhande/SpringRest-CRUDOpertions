package com.mt.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.annotations.EntityBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.entity.Actor;
import com.mt.exception.ActorNotFoundException;
import com.mt.service.ActorService;

@RestController
@RequestMapping("/actor")
public class MyController {

	@Autowired
	ActorService service;

	@PostMapping("/register")
	public String registerActor(@RequestBody Actor actor) {

		String msg= service.registerActor(actor);
		return msg;
	}
	@GetMapping("/report")
	public ResponseEntity<List<Actor>> actorReport(){
		List<Actor> list=service.getAllActors();
		return new ResponseEntity<List<Actor>>(list,HttpStatus.OK);
	}

	@GetMapping("/getActor/{id}")
	public ResponseEntity<Actor> getActorById(@PathVariable int id) throws ActorNotFoundException{
		Optional<Actor> act=service.getActorById(id);

		Actor actor=act.get();
		return new ResponseEntity<Actor>(actor,HttpStatus.OK);	

	}
	@PutMapping("/update")
	public String updateById(@RequestBody Actor actor) throws ActorNotFoundException {
		Optional<Actor> act=service.getActorById(actor.getId());
		if(act.isPresent()) {
			service.registerActor(actor);

			return "Actor updated successfully!!";
		}
		else {
			return "No Actor is in database with id no"+actor.getId();
		}
	}
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) throws ActorNotFoundException {
		Optional<Actor> actor=service.getActorById(id);
		if(actor.isPresent()) {
			String msg=service.deleteById(id);
			return msg;
		}
		else {
			return "No actor with id-"+id;
		}
	}

	@PatchMapping("/updateMovie/{id}/{movie}")
	public String updateMovieById(@PathVariable Integer id,@PathVariable String movie) throws ActorNotFoundException {
		Optional<Actor> actor=service.getActorById(id);
		if(actor.isPresent()) {
			Actor act=actor.get();
			Actor a=new Actor();
			a.setId(id);
			a.setMovie(movie);
			a.setYear(act.getYear());
			service.registerActor(a);
			return  "Movie name "+movie+" is updated successfully at id no "+id;
		}
		else {
			return "No "+id+" Id found.";
		}
	}
	
}

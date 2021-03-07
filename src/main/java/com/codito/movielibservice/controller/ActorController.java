package com.codito.movielibservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codito.movielibservice.model.Actor;
import com.codito.movielibservice.service.ActorService;

@RestController
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	
    
    @GetMapping(path = "/")
	public String welcome() {
		return "Application is Up and Running";	
	}
    
	@GetMapping(path = "/getAllActor")
	public List<Actor> getAllActor() {
		List<Actor> actorList = actorService.getListOfAllActor();
		return actorList;	
	}
	
	@GetMapping(path = "/getActorById")
	public Actor getActorById(@RequestParam int id) {
		Actor actor = actorService.getActor(id);
		return actor;
	}


}

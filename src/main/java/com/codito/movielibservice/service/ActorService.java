package com.codito.movielibservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.codito.movielibservice.mapper.ActorMapper;
import com.codito.movielibservice.model.Actor;

@Service
public class ActorService {
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	private static final String GET_ACTOR_BY_ID = "SELECT actor_id, first_name, last_name, "
			+ " last_update from actor where actor_id = :actorId";
    private static final String GET_ALL_ACTORS = "SELECT actor_id, first_name, last_name, "
    		+ " last_update from actor";
    
    public List<Actor> getListOfAllActor() {
    	return this.namedJdbcTemplate.query(GET_ALL_ACTORS, new ActorMapper());
    }
    
    public Actor getActor(int id) {
    	MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("actorId", id);
		
		return this.namedJdbcTemplate.queryForObject(GET_ACTOR_BY_ID, param, new ActorMapper());
    }

}

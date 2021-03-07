package com.codito.movielibservice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.codito.movielibservice.model.Actor;

public class ActorMapper implements RowMapper<Actor> {
	
	@Override
	public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Actor actor = new Actor();
		
		actor.setActorId(rs.getInt("actor_id"));
		actor.setFirstName(rs.getString("first_name"));
		actor.setLastName(rs.getString("last_name"));
		actor.setLastUpdate(rs.getTimestamp("last_update"));
		
		return actor;
	}

}

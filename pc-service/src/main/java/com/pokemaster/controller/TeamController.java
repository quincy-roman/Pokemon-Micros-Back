package com.pokemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemaster.model.Team;
import com.pokemaster.repository.TeamRepository;

@RestController("teamController")
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	TeamRepository teamRepository;
	
	@GetMapping(path="/{teamId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> retrieveTeamById(@PathVariable int teamId){
		Team currentTeam = teamRepository.findById(teamId).get();
		return ResponseEntity.ok(currentTeam);
	}
	
}



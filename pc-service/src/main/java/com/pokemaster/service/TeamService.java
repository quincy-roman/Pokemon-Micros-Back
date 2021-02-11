package com.pokemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemaster.model.Team;
import com.pokemaster.model.Trainer;
import com.pokemaster.repository.TeamRepository;

@Service("teamService")
public class TeamService {

	@Autowired
	TeamRepository teamRepository;

	public Team findByTrainerId(int trainerId) {
		Team activeTeam = teamRepository.findByTrainer(new Trainer(trainerId));
		if (activeTeam == null) {
			activeTeam = createTeam(trainerId);
			teamRepository.save(activeTeam);
		}
		
		return activeTeam;
	}

	private Team createTeam(int trainerId) {
		Team newTeam = new Team(new Trainer(trainerId));
		return newTeam;
		
	}
}

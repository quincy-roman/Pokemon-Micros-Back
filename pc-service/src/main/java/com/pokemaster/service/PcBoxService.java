package com.pokemaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemaster.model.OwnedPokemon;
import com.pokemaster.model.PcBox;
import com.pokemaster.model.Team;
import com.pokemaster.model.Trainer;
import com.pokemaster.repository.BoxRepository;
import com.pokemaster.repository.OwnedPokemonRepository;
import com.pokemaster.repository.TeamRepository;

@Service("pcBoxService")
public class PcBoxService {
	
	@Autowired
	BoxRepository boxRepository;
	
	@Autowired
	OwnedPokemonRepository opRepository;
	
	@Autowired
	TeamRepository teamRepository;

	public PcBox createNewBox(Trainer owner, String name) {
		PcBox newBox = new PcBox(name, owner);
		return boxRepository.save(newBox);
	}
	
	public List<PcBox> getBoxesByTrainer(int trainerId){
		 return boxRepository.findAllByOwner(new Trainer(trainerId));
	}
	
	public void addToBox(int boxId, int pokemonId) {
		/*
		 * Add validation for box and pokemon ownership
		 */
		PcBox activeBox = boxRepository.findById(boxId).get();
		OwnedPokemon activePokemon = opRepository.findById(pokemonId).get();
		activePokemon.setPcBox(activeBox);
		activePokemon.setTeam(null);
		opRepository.save(activePokemon);
	}
	
	public void removeFromBox(int teamId, int pokemonId) {
		OwnedPokemon activePokemon = opRepository.findById(pokemonId).get();
		Team activeTeam = teamRepository.findById(teamId).get();
		activePokemon.setPcBox(null);
		activePokemon.setTeam(activeTeam);
		opRepository.save(activePokemon);
	}
	
	
}

package com.pokemaster.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemaster.dto.OwnedPokemonDTO;
import com.pokemaster.dto.TrainerRollDTO;
import com.pokemaster.model.OwnedPokemon;
import com.pokemaster.model.Trainer;
import com.pokemaster.service.BasePokemonService;
import com.pokemaster.service.GachaService;
import com.pokemaster.service.TrainerService;

@RestController()
@RequestMapping("/gacha")
@CrossOrigin("http://localhost:4200")
public class GachaController {

	@Autowired
	BasePokemonService basePokeServ;

	@Autowired
	GachaService gachaServ;

	@Autowired
	TrainerService trainerServ;

	private final int COST_PER_ROLL = 100;

	/**
	 * Triggers the gacha rolling mechanic. Needs to be provided the trainer & the
	 * number of rolls that are requested.
	 * 
	 * @param trainer
	 * @param numOfRolls
	 * @return
	 */
	@PostMapping("/roll")
	public ResponseEntity<List<OwnedPokemonDTO>> rollGacha(@RequestBody TrainerRollDTO data)
			 {
		// Check if the trainer has enough money to do the rolls
		Trainer trainer = trainerServ.findTrainerById(data.getTrainerId());
		if (trainer.getPoke() >= (COST_PER_ROLL * data.getNumOfRolls())) {
			// Subtract cost of rolls
			trainer.setPoke(trainer.getPoke() - (COST_PER_ROLL * data.getNumOfRolls()));
			// Get the new pokemon
			List<OwnedPokemon> newPokes =  gachaServ.assignGacha(trainer, data.getNumOfRolls());
			List<OwnedPokemonDTO> dtoPokes = new ArrayList<>();
			for(int i = 0; i <newPokes.size();i++)
			{
				dtoPokes.add(OwnedPokemonDTO.convertToDTO(newPokes.get(i)));
			}
			// Return pokemon to the client
			ResponseEntity<List<OwnedPokemonDTO>> ret;
			
			ret = ResponseEntity.ok(dtoPokes);
			return ret;
		} else {
			return null;
		}

	}

}

package com.pokemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pokemaster.model.ClientMessage;
import com.pokemaster.model.OwnedPokemon;
import com.pokemaster.model.Trainer;
import com.pokemaster.service.BasePokemonService;
import com.pokemaster.service.GachaService;
import com.pokemaster.service.TrainerService;

@RestController()
@CrossOrigin("localhost:4200")
public class GachaController {
	
	
	@Autowired
	BasePokemonService basePokeServ;
	
	@Autowired
	GachaService gachaServ;
	
	@Autowired
	TrainerService trainerServ;
	
	private final int COST_PER_ROLL = 100;

	
	
	/**
	 * Triggers the gacha rolling mechanic. Needs to be provided the trainer & the number of rolls that are requested.
	 * @param trainer
	 * @param numOfRolls
	 * @return
	 */
	@PostMapping("/roll")
	public ResponseEntity<ClientMessage<OwnedPokemon[]>> rollGacha(@RequestBody int trainerId, @RequestBody int numOfRolls)
	{
		//Check if the trainer has enough money to do the rolls
		Trainer trainer = trainerServ.findTrainerById(trainerId);
		if(trainer.getPoke() >= (COST_PER_ROLL*numOfRolls))
		{
			//Subtract cost of rolls
			trainer.setPoke(trainer.getPoke() - (COST_PER_ROLL * numOfRolls));
			//Get the new pokemon
			OwnedPokemon[] newPokes = (OwnedPokemon[]) gachaServ.assignGacha(trainer, numOfRolls).toArray();
			
			//Return pokemon to the client
			ResponseEntity<ClientMessage<OwnedPokemon[]>> ret;
			ClientMessage<OwnedPokemon[]> message = new ClientMessage<OwnedPokemon[]>(newPokes);
			ret = ResponseEntity.ok(message);
			return ret;
		}
		else {
			return null;
		}
		
		
		
		
		
	}
	
	
	
	
	
	

}

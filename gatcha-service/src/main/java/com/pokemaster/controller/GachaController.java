package com.pokemaster.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pokemaster.dto.PokemonDTO;
import com.pokemaster.model.BasePokemon;
import com.pokemaster.model.ClientMessage;
import com.pokemaster.model.OwnedPokemon;
import com.pokemaster.model.Trainer;
import com.pokemaster.service.BasePokemonService;
import com.pokemaster.service.GachaService;

@RestController()
@CrossOrigin("localhost:4200")
public class GachaController {
	
	
	@Autowired
	BasePokemonService basePokeServ;
	
	@Autowired
	GachaService gachaServ;
	
	private final int COST_PER_ROLL = 100;

	/**
	 * This method will most likely be removed/changed, but here's the idea:
	 * It takes a ton of classes to make a Pokemon object from the PokeAPI, and contains a lot of unneeded info for {@link BasePokemon}
	 * Instead we'll let a front end client (written in angular) convert the raw JSON data to our pokemonDTO model and send that back.
	 * This way we don't need to manually create tons of  java classes everytime a pokemon is added to the database. 
	 * @param pokemon
	 * @return
	 */
	@PostMapping("/populate")
	public ResponseEntity<ClientMessage<String>> populateDatabase(@RequestBody List<PokemonDTO> pokemon)
	{
		List<BasePokemon> convertedPoke = new ArrayList<>();
		for(PokemonDTO p : pokemon)
		{
			convertedPoke.add(p.convertToBasePokemon());
		}
		
		basePokeServ.saveAll(convertedPoke);
		ResponseEntity<ClientMessage<String>> ret;
		ClientMessage<String> m = new ClientMessage<String>("Data saved to database");
		ret = ResponseEntity.ok(m);
		return ret;
		
	}
	
	
	/**
	 * Triggers the gacha rolling mechanic. Needs to be provided the trainer & the number of rolls that are requested.
	 * @param trainer
	 * @param numOfRolls
	 * @return
	 */
	@PostMapping("/roll")
	public ResponseEntity<ClientMessage<OwnedPokemon[]>> rollGacha(@RequestBody Trainer trainer, @RequestBody int numOfRolls)
	{
		//Check if the trainer has enough money to do the rolls
		if(trainer.getPoke() >= (COST_PER_ROLL*numOfRolls))
		{
			//Subtract cost of rolls
			trainer.setPoke(trainer.getPoke() - (COST_PER_ROLL * numOfRolls));
			//Get the new pokemon
			OwnedPokemon[] newPokes = (OwnedPokemon[]) gachaServ.assignGacha(trainer, numOfRolls).toArray();
			
			//Return pokemon to the client
			ResponseEntity<ClientMessage<OwnedPokemon[]>> ret;
			ClientMessage<OwnedPokemon[]> message = new ClientMessage<OwnedPokemon[]>("Rolls complete", newPokes);
			ret = ResponseEntity.ok(message);
			return ret;
		}
		else {
			return null;
		}
		
		
		
		
		
	}
	
	
	
	
	
	

}

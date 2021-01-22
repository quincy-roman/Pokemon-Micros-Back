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
import com.pokemaster.repository.BasePokemonRepository;

@RestController()
@CrossOrigin("localhost:4200")
public class GachaController {
	
	
	@Autowired
	BasePokemonRepository pokeRepo;
	
	@PostMapping("/populate")
	public ResponseEntity<ClientMessage> populateDatabase(@RequestBody List<PokemonDTO> pokemon)
	{
		List<BasePokemon> convertedPoke = new ArrayList<>();
		for(PokemonDTO p : pokemon)
		{
			convertedPoke.add(p.convertToBasePokemon());
		}
		
		pokeRepo.saveAll(convertedPoke);
		ResponseEntity<ClientMessage> ret;
		ClientMessage m = new ClientMessage("Data saved to database");
		ret = ResponseEntity.ok(m);
		return ret;
		
	}
	
	
	
	

}

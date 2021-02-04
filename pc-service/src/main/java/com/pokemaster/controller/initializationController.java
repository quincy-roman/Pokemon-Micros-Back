package com.pokemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokemaster.service.OwnedPokemonService;

@RestController("initializationController")
@RequestMapping("/init")
public class initializationController {

	@Autowired
	private OwnedPokemonService opService;
	
	@PostMapping("/startup")
	public ResponseEntity<String> initializeOwnedPokemon(){
		int numberOfPokemon = 15;
		int trainerId = 1;
		opService.initOwnedPokemon(numberOfPokemon, trainerId);
		return ResponseEntity.status(HttpStatus.CREATED).body("Complete");
	}
	
}

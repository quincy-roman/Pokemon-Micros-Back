package com.pokemaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokemaster.model.PcBox;
import com.pokemaster.model.Trainer;
import com.pokemaster.service.PcBoxService;

@RestController("pcBoxController")
@RequestMapping("/pc")
public class PcBoxController {

	@Autowired
	PcBoxService boxService;
	
	@PostMapping("/create")
	public ResponseEntity<PcBox> createNewBox(@RequestParam int trainerId, @RequestParam String boxName){
		PcBox createdBox = boxService.createNewBox(new Trainer(trainerId), boxName);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdBox);
	}
	
	@GetMapping(path="/retrieve/{trainerId}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<PcBox>> retrieveBoxesByTrainer(@PathVariable int trainerId){
		List<PcBox> boxes = boxService.getBoxesByTrainer(trainerId);
		return ResponseEntity.ok(boxes);
	}
	
	@PutMapping("/addPokemon")
	public ResponseEntity<String> addPokemonToBox(@RequestParam int boxId, @RequestParam int pokemonId){
		boxService.addToBox(boxId, pokemonId);
		return ResponseEntity.status(HttpStatus.OK).body("Update complete");
	}
	
	@PutMapping("/removePokemon")
	public ResponseEntity<String> transferPokemonToTeam(@RequestParam int teamId, @RequestParam int pokemonId){
		boxService.removeFromBox(teamId, pokemonId);
		return ResponseEntity.status(HttpStatus.OK).body("Update complete");
	}
}

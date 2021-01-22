package com.pokemaster.service;

import java.util.List;

import com.pokemaster.model.BasePokemon;
import com.pokemaster.model.OwnedPokemon;
import com.pokemaster.model.Rarity;
import com.pokemaster.model.Trainer;

public interface GachaService {

	//Drop rates for each rarity
	public float UNCOMMON_DROP_RATE = 50.3f;
	public float RARE_DROP_RATE = 17.2f;
	public float LEGENDARY_DROP_RATE = 1.8f;
	public float MYTHIC_DROP_RATE = 0.4f;
	
	
	
	public List<BasePokemon> rollGacha(int numOfRolls); //Generic "random" rolls
	
	public List<OwnedPokemon> assignGacha(Trainer trainer, int numOfRolls); //Assigns pokemons to the correct trainer and saves them
	
	public List<BasePokemon> rollStarterGacha(); //Rolls the starting 6 pokemon a trainer gets when they first register
	
	
	//Evaluates the roll based on drop rates and returns a specified rarity.
	public Rarity evaluateRoll(double roll);
	
	public BasePokemon getRandomPokemon(Rarity rarity);
	
	
	
	
}

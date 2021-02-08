package com.pokemaster.service;

import java.util.List;

import com.pokemaster.model.BasePokemon;
import com.pokemaster.model.Rarity;

public interface BasePokemonService {

	public List<BasePokemon> saveAll(List<BasePokemon> all);
	
	public BasePokemon save(BasePokemon pokemon);
	
	public List<BasePokemon> findAll();
	
	public List<BasePokemon> findWithRarity(Rarity rarity);
	
	public BasePokemon findById(int id);
}

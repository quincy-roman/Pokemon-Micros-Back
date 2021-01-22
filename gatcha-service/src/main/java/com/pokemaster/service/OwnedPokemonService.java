package com.pokemaster.service;

import java.util.List;

import com.pokemaster.model.OwnedPokemon;

public interface OwnedPokemonService {
public List<OwnedPokemon> saveAll(List<OwnedPokemon> all);
	
	public OwnedPokemon save(OwnedPokemon pokemon);
		
	public void delete(OwnedPokemon pokemon);
	
}

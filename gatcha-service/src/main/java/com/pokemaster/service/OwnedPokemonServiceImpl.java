package com.pokemaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemaster.model.OwnedPokemon;
import com.pokemaster.repository.OwnedPokemonRepository;

@Service
public class OwnedPokemonServiceImpl implements OwnedPokemonService {

	
	@Autowired
	OwnedPokemonRepository repo;
	
	
	@Override
	public List<OwnedPokemon> saveAll(List<OwnedPokemon> all) {
		// TODO Auto-generated method stub
		return repo.saveAll(all);
	}

	@Override
	public OwnedPokemon save(OwnedPokemon pokemon) {
		// TODO Auto-generated method stub
		return repo.save(pokemon);
	}

	@Override
	public void delete(OwnedPokemon pokemon) {
		// TODO Auto-generated method stub
		repo.delete(pokemon);
	}

}

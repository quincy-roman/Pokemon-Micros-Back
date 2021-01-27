package com.pokemaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemaster.model.BasePokemon;
import com.pokemaster.model.Rarity;
import com.pokemaster.repository.BasePokemonRepository;

@Service
public class BasePokemonServiceImpl implements BasePokemonService {

	@Autowired
	BasePokemonRepository repo;
	
	
	@Override
	public List<BasePokemon> saveAll(List<BasePokemon> all) {
		// TODO Auto-generated method stub
		return repo.saveAll(all);
	}

	@Override
	public BasePokemon save(BasePokemon pokemon) {
		// TODO Auto-generated method stub
		return repo.save(pokemon);
	}

	@Override
	public List<BasePokemon> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<BasePokemon> findWithRarity(Rarity rarity) {
		// TODO Auto-generated method stub
		return repo.findByRarity(rarity);
	}



}

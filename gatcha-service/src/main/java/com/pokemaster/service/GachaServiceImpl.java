package com.pokemaster.service;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemaster.model.BasePokemon;
import com.pokemaster.model.OwnedPokemon;
import com.pokemaster.model.Rarity;
import com.pokemaster.model.Trainer;
import com.pokemaster.repository.BasePokemonRepository;

@Service
public class GachaServiceImpl implements GachaService {

	private static Logger log = Logger.getLogger(GachaServiceImpl.class);

	@Autowired
	BasePokemonRepository basePokeRepo;

	@Override
	public List<BasePokemon> rollGacha(int numOfRolls) {

		log.info("Rolling " + numOfRolls + " in GachaServiceImpl!");
		List<BasePokemon> rolledPokes = new ArrayList<>();
		for (int i = 0; i < numOfRolls; i++) {
			// Random % for rarity
			double rand = Math.random() * 100;
			// get the rarity
			Rarity r = evaluateRoll(rand);
			// randomly get pokemon based on rarity roll.
			BasePokemon pokemon = getRandomPokemon(r);
			rolledPokes.add(pokemon);

		}
		return rolledPokes;
	}

	@Override
	public List<OwnedPokemon> assignGacha(Trainer trainer, int numOfRolls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BasePokemon> rollStarterGacha() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BasePokemon> rollWeightedGatcha(int numOfRolls, Rarity guaranteedRarity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rarity evaluateRoll(double roll) {
		if (roll <= MYTHIC_DROP_RATE) {
			return Rarity.MYTHIC;
		} else if (roll <= LEGENDARY_DROP_RATE) {
			return Rarity.LEGENDARY;
		} else if (roll <= RARE_DROP_RATE) {
			return Rarity.RARE;
		} else if (roll <= UNCOMMON_DROP_RATE) {
			return Rarity.UNCOMMON;
		} else {
			return Rarity.COMMON;

		}
	}

	@Override
	public BasePokemon getRandomPokemon(Rarity rarity) {
		//Get all pokemon
		List<BasePokemon> foundPokemon = basePokeRepo.findByRarity(rarity);
		
		int rand = 1 + (int) Math.random() * (foundPokemon.size() - 1);
		return foundPokemon.get(rand);
	}

}

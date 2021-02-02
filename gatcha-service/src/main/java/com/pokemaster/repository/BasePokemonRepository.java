package com.pokemaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemaster.model.BasePokemon;
import com.pokemaster.model.Rarity;

@Repository
public interface BasePokemonRepository extends JpaRepository<BasePokemon, Integer> {

	List<BasePokemon> findByRarity(Rarity rarity);

}

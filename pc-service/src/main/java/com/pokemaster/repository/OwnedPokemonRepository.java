package com.pokemaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemaster.model.OwnedPokemon;
import com.pokemaster.model.Trainer;

@Repository
public interface OwnedPokemonRepository extends JpaRepository<OwnedPokemon, Integer>{

	List<OwnedPokemon> findAllByCurrentTrainer(Trainer owner);
}

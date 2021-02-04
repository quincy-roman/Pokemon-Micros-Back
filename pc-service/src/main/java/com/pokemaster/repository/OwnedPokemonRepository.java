package com.pokemaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemaster.model.OwnedPokemon;

@Repository
public interface OwnedPokemonRepository extends JpaRepository<OwnedPokemon, Integer>{

}

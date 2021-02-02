package com.pokemaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemaster.model.BasePokemon;

@Repository
public interface BasePokemonRepository extends JpaRepository<BasePokemon, Integer>{

}

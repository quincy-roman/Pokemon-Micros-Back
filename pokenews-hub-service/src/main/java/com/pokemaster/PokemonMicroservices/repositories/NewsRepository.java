package com.pokemaster.PokemonMicroservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemaster.PokemonMicroservices.models.NewsFeed;

@Repository
public interface NewsRepository extends JpaRepository<NewsFeed, Integer>{

}

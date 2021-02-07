package com.pokemaster.PokemonMicroservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pokemaster.PokemonMicroservices.models.NewsFeed;

@Repository
public interface NewsRepository extends JpaRepository<NewsFeed, Integer>{

	@Modifying
	@Query(
            value = "truncate table NEWS",
            nativeQuery = true
    )
	public void truncateTable();
}

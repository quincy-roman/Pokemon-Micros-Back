package com.pokemaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemaster.model.Team;
import com.pokemaster.model.Trainer;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{

	Team findByTrainer(Trainer owner);
}

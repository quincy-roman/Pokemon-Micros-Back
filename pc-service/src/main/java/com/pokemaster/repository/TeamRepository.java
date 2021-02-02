package com.pokemaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemaster.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{

}

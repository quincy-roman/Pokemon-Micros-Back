package com.pokemaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemaster.model.Trainer;

@Repository
public interface LoginRepository extends JpaRepository<Trainer, Integer>{
	
	Trainer findByEmailAndPassword(String email, String password);

}

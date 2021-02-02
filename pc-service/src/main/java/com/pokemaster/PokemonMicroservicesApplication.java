package com.pokemaster;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pokemaster.service.OwnedPokemonService;

@SpringBootApplication
public class PokemonMicroservicesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PokemonMicroservicesApplication.class, args);
		
	}

}

package com.pokemaster.PokemonMicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.pokemaster.model")
public class PokemonMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonMicroservicesApplication.class, args);
	}

}

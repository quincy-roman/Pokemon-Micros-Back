package com.pokemaster.PokemonMicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class PokemonMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonMicroservicesApplication.class, args);
	}

}

package com.pokemaster.exception;

public class PokemonNotFoundException extends RuntimeException {

	public PokemonNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}
	
}

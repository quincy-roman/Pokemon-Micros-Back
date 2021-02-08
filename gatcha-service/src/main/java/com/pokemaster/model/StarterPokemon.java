package com.pokemaster.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum StarterPokemon {

	BULBASAUR(1),
	CHARMANDER(4),
	SQUIRTLE(7),
	PIKACHU(25);
	
	private int pokeId;
	StarterPokemon(int pokeId)
	{
		this.pokeId = pokeId;
	}
	
	public int getPokeId()
	{
		return pokeId;
	}
	
	private static final List<StarterPokemon> VALUES =
			Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	public static StarterPokemon randomStarter()
	{
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
	
	
}

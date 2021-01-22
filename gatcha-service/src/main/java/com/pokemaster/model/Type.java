package com.pokemaster.model;

// The types that both a Pokemon and a Pokemon move can have.
public enum Type {
	
	NONE,
	NORMAL,
	FIRE,
	WATER,
	GRASS,
	ICE,
	ELECTRIC,
	FIGHTING,
	POISON,
	GROUND,
	FLYING,
	PSYCHIC,
	BUG,
	ROCK,
	GHOST,
	DARK,
	DRAGON,
	STEEL,
	FAIRY;

	
	public static Type getType(String type)
	{
		
		switch (type.toUpperCase())
		{
		case "":
			return Type.NONE;
		case "NORMAL":
			return Type.NORMAL;
		case "FIRE":
			return Type.FIRE;
		case "WATER":
			return Type.WATER;
		case "GRASS":
			return Type.GRASS;
		case "ICE":
			return Type.ICE;
		case "ELECTRIC":
			return Type.ELECTRIC;
		case "FIGHTING":
			return Type.FIGHTING;
		case "POISON":
			return Type.POISON;
		case "GROUND":
			return Type.GROUND;
		case "FLYING":
			return Type.FLYING;
		case "PSYCHIC":
			return Type.PSYCHIC;
		case "BUG":
			return Type.BUG;
		case "ROCK":
			return Type.ROCK;
		case "GHOST":
			return Type.GHOST;
		case "DARK":
			return Type.DARK;
		case "DRAGON":
			return Type.DRAGON;
		case "STEEL":
			return Type.STEEL;
		case "FAIRY":
			return Type.FAIRY;
		 default:
			return Type.NONE;
		}
	}
	
	
}

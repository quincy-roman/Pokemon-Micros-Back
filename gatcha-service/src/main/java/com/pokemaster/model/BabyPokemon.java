package com.pokemaster.model;

/* Baby Pokemon are treated as separate for the gatcha.
 * Typically, only first stage Pokemon would be allowed
 * in rolls.
 * However, Pokemon that evolve from the baby Pokemon below
 * are also obtainable in a normal roll.
 * 
 * For instance, if the roll is a Charizard, a Charmander would 
 * be obtained.
 * If a Pikachu was rolled, a Pikachu would be obtained.
 */
public enum BabyPokemon {
	
	PICHU,
	CLEFFA,
	IGGLYBUFF,
	TOGEPI,
	TYROUGE,
	SMOOCHUM,
	ELEKID,
	MAGBY,
	AZURILL,
	WYNAUT,
	BUDEW,
	CHINGLING,
	BONSLY,
	MIME_JR,	// This will be an issue.
	HAPPINY,
	MUNCHLAX,
	RIOLU,
	MANTYKE,
	TOXEL

}

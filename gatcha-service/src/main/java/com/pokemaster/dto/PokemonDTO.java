package com.pokemaster.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pokemaster.model.BasePokemon;
import com.pokemaster.model.Rarity;
import com.pokemaster.model.Type;

import lombok.Data;

@Data
public class PokemonDTO {

	private int national_id;

	private final String SPECIES; // Species name.

	private final String TYPE_ONE; // Primary type.

	private final String TYPE_TWO; // Optional secondary type

	private final String ABILITY; // This will get complicated.

	private final int MAX_HP; // Amount of health

	private final int ATK; // Physical attacking power

	private final int DEF; // Physical defensive power

	private final int SPATK; // Special attack

	private final int SPDEF; // Special defense

	private final int SPD; // Speed

	private final int rarity; // The rarity of the Pokemon in the gacha mechanic.

	private final boolean IS_EVOLUTION; // If a pokemon is an evolved form or not. Affects if it can be rolled in drop
										// table.

	private final String EVOLUTION; //Form from which the pokemon evolved from.

	private final String DEX_ENTRY;

//	public PokemonDTO()
//	{
//		super();
//		this.national_id = 0;
//		SPECIES = "";
//		TYPE_ONE = "";
//		TYPE_TWO = "";
//		ABILITY = "";
//		MAX_HP = 0;
//		ATK = 0;
//		DEF = 0;
//		SPATK = 0;
//		SPDEF = 0;
//		SPD = 0;
//		this.rarity = 0;
//		IS_EVOLUTION= false;
//		EVOLUTION = "";
//		DEX_ENTRY = "";
//	}

	public PokemonDTO(int national_id, String sPECIES, String tYPE_ONE, String tYPE_TWO, String aBILITY, int mAX_HP,
			int aTK, int dEF, int sPATK, int sPDEF, int sPD, String eVOLUTION, String dEX_ENTRY) {
		super();
		this.national_id = national_id;
		SPECIES = sPECIES;
		TYPE_ONE = tYPE_ONE;
		TYPE_TWO = tYPE_TWO;
		ABILITY = aBILITY;
		MAX_HP = mAX_HP;
		ATK = aTK;
		DEF = dEF;
		SPATK = sPATK;
		SPDEF = sPDEF;
		SPD = sPD;
		this.rarity = 0;
		EVOLUTION = eVOLUTION;
		if (!eVOLUTION.equals("")) {
			IS_EVOLUTION = true;

		} else {
			IS_EVOLUTION = false;
		}
		DEX_ENTRY = dEX_ENTRY;
	}
	
	@JsonCreator
	public PokemonDTO(@JsonProperty("national_id") int national_id,
			@JsonProperty("species") String species,@JsonProperty("stats") int[] stats, 
			@JsonProperty("type_one") String type_one,@JsonProperty("type_two") String type_two,
			@JsonProperty("ability") String ability,@JsonProperty("pre-evolution") String preevolution,
			@JsonProperty("dex entry") String dex_entry) {
		super();
		this.national_id = national_id;
		SPECIES = species;
		TYPE_ONE = type_one;
		TYPE_TWO = type_two;
		ABILITY = ability;
		MAX_HP = stats[0];
		ATK = stats[1];
		DEF = stats[2];
		SPATK = stats[3];
		SPDEF = stats[4];
		SPD = stats[5];
		this.rarity = 0;
		EVOLUTION = preevolution;
		if (!preevolution.equals("")) {
			IS_EVOLUTION = true;

		} else {
			IS_EVOLUTION = false;
		}
		DEX_ENTRY = dex_entry;
	}
	
	

	public BasePokemon convertToBasePokemon() {
		float avg = (MAX_HP + ATK + DEF + SPATK + SPDEF + SPD) / 6;

		return new BasePokemon(national_id, SPECIES, Type.getType(TYPE_ONE), Type.getType(TYPE_TWO), ABILITY, MAX_HP,
				ATK, DEF, SPATK, SPDEF, SPD, Rarity.getRarityfromAvg(avg), IS_EVOLUTION, EVOLUTION,DEX_ENTRY);

	}

}

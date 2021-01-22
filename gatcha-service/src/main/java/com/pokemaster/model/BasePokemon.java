package com.pokemaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "base_pokemon")
@Data
public class BasePokemon {
	
	@Id
	@Column(name = "national_id")
	private int nationalId;
	
	@Column(name = "species", nullable = false)
	private final String SPECIES;	// Species name.
	
	@Column(name = "type_one", nullable = false)
	private final Type TYPE_ONE; // Primary type.
	
	@Column(name = "type_two")
	private final Type TYPE_TWO; // Optional secondary type
	
	@Column(name = "ability", nullable = false)
	private final String ABILITY;	// This will get complicated.
	
	@Column(name = "max_hp", nullable = false)
	private final int MAX_HP; // Amount of health
	
	@Column(name = "atk", nullable = false)
	private final int ATK; // Physical attacking power
	
	@Column(name = "def", nullable = false)
	private final int DEF; // Physical defensive power
	
	@Column(name = "sp_atk", nullable = false)
	private final int SPATK; // Special attack
	
	@Column(name = "sp_def", nullable = false)
	private final int SPDEF;	// Special defense
	
	@Column(name = "spd", nullable = false)
	private final int SPD; // Speed
	
	@Column(name = "rarity", nullable = false)
	private final Rarity rarity;	// The rarity of the Pokemon in the gacha mechanic.
	
	@Column(name = "is_evolution")
	private final boolean IS_EVOLUTION; //If a pokemon is an evolved form or not. Affects if it can be rolled in drop table.
	
	@Column(name = "evolution")
	private final String EVOLUTION;
	public BasePokemon()
	{
		super();
		this.nationalId = 0;
		SPECIES = "";
		TYPE_ONE = Type.NONE;
		TYPE_TWO = Type.NONE;
		ABILITY = "";
		MAX_HP = 0;
		ATK = 0;
		DEF = 0;
		SPATK = 0;
		SPDEF = 0;
		SPD = 0;
		this.rarity = Rarity.COMMON;
		IS_EVOLUTION= false;
		EVOLUTION = "";
	}
	
	public BasePokemon(int nationalId, String sPECIES, Type tYPE_ONE, Type tYPE_TWO, String aBILITY, int mAX_HP, int aTK,
			int dEF, int sPATK, int sPDEF, int sPD, Rarity rarity,boolean iS_EVOLUTION,String eVOLUTION) {
		super();
		this.nationalId = nationalId;
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
		this.rarity = rarity;
		IS_EVOLUTION= iS_EVOLUTION;
		EVOLUTION = eVOLUTION;
	}
	
	// Future functionality here.

}

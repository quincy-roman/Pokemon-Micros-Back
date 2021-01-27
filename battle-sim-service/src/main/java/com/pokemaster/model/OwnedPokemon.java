package com.pokemaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "owned_pokemon")
@Data
public class OwnedPokemon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pokemon_id")
	private int pokemonId;
	
	@Column(name = "species", nullable = false)
	private final String SPECIES;	// Species name.
	
	@Column(name = "nickname")
	private String nickname;	// A given nickname. Can be changed by the trainer.
	
	@Column(name = "ot", nullable = false)
	private final Trainer OT;	// Original Trainer: the original owner of this Pokemon.
	
	@Column(name = "current_trainer", nullable = false)
	private Trainer currentTrainer;	// The current trainer of this Pokemon.
	
	@Column(name = "type_one", nullable = false)
	private final Type TYPE_ONE; // Primary type.
	
	@Column(name = "type_two")
	private final Type TYPE_TWO; // Optional secondary type
	
	@Column(name = "ability", nullable = false)
	private final String ABILITY;	// This will get complicated.
	
	@Column(name = "level", nullable = false, columnDefinition = "int default 50")
	private final int LEVEL = 50;	// Level set to a standard 50.
	
	@Column(name = "status")
	private Status status;	// Status condition.
	
	@Column(name = "max_hp", nullable = false)
	private final int MAX_HP; // Amount of health
	
	@Column(name = "current_hp", nullable = false)
	private int currentHp;
	
	@Column(name = "atk", nullable = false)
	private final int ATK; // Physical attacking power
	
	@Column(name = "def", nullable = false)
	private final int DEF; // Physical defensive power
	
	@Column(name = "sp_atk", nullable = false)
	private final int SP_ATK; // Special attack
	
	@Column(name = "sp_def", nullable = false)
	private final int SP_DEF;	// Special defense
	
	@Column(name = "spd", nullable = false)
	private final int SPD; // Speed
	
	@Column(name = "rarity", nullable = false)
	private final Rarity rarity;	// The rarity of the Pokemon in the gacha mechanic.
	
	@Column(name = "is_fainted", nullable = false, columnDefinition = "boolean default false")
	private boolean isFainted;
	
	@Column(name = "in_battle", nullable = false, columnDefinition = "boolean default false")
	private boolean inBattle;
	
//	@Column(name = "held_item")	Maybe in a later version.
//	private Item heldItem;
	
	// TODO: Moves will need to be implemented.

	public OwnedPokemon(int pokemonId, String sPECIES, String nickname, Trainer oT, Trainer currentTrainer,
			Type tYPE_ONE, Type tYPE_TWO, String aBILITY, Status status, int mAX_HP, int currentHp, int aTK, int dEF,
			int sP_ATK, int sP_DEF, int sPD, Rarity rarity, boolean isFainted, boolean inBattle) {
		super();
		this.pokemonId = pokemonId;
		SPECIES = sPECIES;
		this.nickname = nickname;
		OT = oT;
		this.currentTrainer = currentTrainer;
		TYPE_ONE = tYPE_ONE;
		TYPE_TWO = tYPE_TWO;
		ABILITY = aBILITY;
		this.status = status;
		MAX_HP = mAX_HP;
		this.currentHp = currentHp;
		ATK = aTK;
		DEF = dEF;
		SP_ATK = sP_ATK;
		SP_DEF = sP_DEF;
		SPD = sPD;
		this.rarity = rarity;
		this.isFainted = isFainted;
		this.inBattle = inBattle;
	}
	
	// Future functionality here.

}

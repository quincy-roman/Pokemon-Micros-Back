package com.pokemaster.dto;

import java.io.Serializable;

import com.pokemaster.model.OwnedPokemon;

import lombok.Data;

@Data
public class OwnedPokemonDTO implements Serializable {

	private int pokemonId;

	private String species; // Species name.

	private String nickname; // A given nickname. Can be changed by the trainer.

	private int OT; // Original Trainer: the original owner of this Pokemon.

	private int currentTrainer; // The current trainer of this Pokemon.

	private String typeOne; // Primary type.

	private String typeTwo; // Optional secondary type

	private String ability; // This will get complicated.

	private int level = 50; // Level set to a standard 50.

	private String status; // Status condition.

	private int maxHp; // Amount of health

	private int currentHp;

	private int atk; // Physical attacking power

	private int def; // Physical defensive power

	private int spAtk; // Special attack

	private int spDef; // Special defense

	private int spd; // Speed

	private String rarity; // The rarity of the Pokemon in the gacha mechanic.

	private boolean isFainted;

	private boolean inBattle;

	public static OwnedPokemonDTO convertToDTO(OwnedPokemon pokemon) {
		return new OwnedPokemonDTO(pokemon.getPokemonId(), pokemon.getSPECIES(), pokemon.getNickname(),
				pokemon.getOT().getTrainerId(), pokemon.getCurrentTrainer().getTrainerId(),
				pokemon.getTYPE_ONE().toString(), pokemon.getTYPE_TWO().toString(), pokemon.getABILITY(),
				pokemon.getLEVEL(), pokemon.getStatus().toString(), pokemon.getMAX_HP(), pokemon.getCurrentHp(),
				pokemon.getATK(), pokemon.getDEF(), pokemon.getSP_ATK(), pokemon.getSP_DEF(), pokemon.getSPD(),
				pokemon.getRarity().toString(), pokemon.isFainted(), pokemon.isInBattle());
	}

	public OwnedPokemonDTO(int pokemonId, String species, String nickname, int oT, int currentTrainer, String typeOne,
			String typeTwo, String ability, int level, String status, int maxHp, int currentHp, int atk, int def,
			int spAtk, int spDef, int spd, String rarity, boolean isFainted, boolean inBattle) {
		super();
		this.pokemonId = pokemonId;
		this.species = species;
		this.nickname = nickname;
		OT = oT;
		this.currentTrainer = currentTrainer;
		this.typeOne = typeOne;
		this.typeTwo = typeTwo;
		this.ability = ability;
		this.level = level;
		this.status = status;
		this.maxHp = maxHp;
		this.currentHp = currentHp;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.spd = spd;
		this.rarity = rarity;
		this.isFainted = isFainted;
		this.inBattle = inBattle;
	}
}

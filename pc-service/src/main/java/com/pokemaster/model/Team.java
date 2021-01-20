package com.pokemaster.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team")
@Data
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private int teamId;
	
	@Column(name = "trainer")
	private Trainer trainer;
	
	@Column(name = "pokemon")
	private List<OwnedPokemon> pokemon;	// Can be no greater than 6.

	public Team(int teamId, Trainer trainer, List<OwnedPokemon> pokemon) {
		super();
		this.teamId = teamId;
		this.trainer = trainer;
		this.pokemon = pokemon;
	}
	
	// TODO: Finish.

}

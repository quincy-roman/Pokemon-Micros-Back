package com.pokemaster.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "team")
@Data
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private int teamId;
	
	@OneToOne(targetEntity=Trainer.class)
	private Trainer trainer;
	
	@OneToMany(mappedBy="team")
	@JsonManagedReference
	private List<OwnedPokemon> pokemon;	// Can be no greater than 6.

	public Team(int teamId, Trainer trainer, List<OwnedPokemon> pokemon) {
		super();
		this.teamId = teamId;
		this.trainer = trainer;
		this.pokemon = pokemon;
	}
	
	
	public Team() {
		super();
	}

	public Team(Trainer trainer) {
		super();
		this.trainer = trainer;
	}
	
	
	
	// TODO: Finish.

}

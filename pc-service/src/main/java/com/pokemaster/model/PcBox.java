package com.pokemaster.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "pc_box")
@Data
public class PcBox {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "box_id")
	private int boxId;
	
	@Column(name = "name", nullable = false)
	private String name;	// Name of the box.
	
	@Column(name = "owner", nullable = false)
	private Trainer owner;	// The trainer who owns the box.
	
	@Column(name = "pokemon")
	@ManyToOne	// TODO: Fix
	private List<OwnedPokemon> pokemon;	// Pokemon within that box. TODO: Once it hits length 30, a new box is needed.

	public PcBox(int boxId, String name, Trainer owner, List<OwnedPokemon> pokemon) {
		super();
		this.boxId = boxId;
		this.name = name;
		this.owner = owner;
		this.pokemon = pokemon;
	}
	
	/*
	 * TODO: Add functionality.
	 * 
	 * Include a system of keeping track of the box size so 
	 * that new entries spill into another box.
	 */ 

}

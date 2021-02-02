package com.pokemaster.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@JoinColumn(name = "owner", nullable = false)
	@ManyToOne
	private Trainer owner;	// The trainer who owns the box.
	
	@JsonManagedReference
	@OneToMany(mappedBy="pcBox")
	private List<OwnedPokemon> pokemon;	// Pokemon within that box. TODO: Once it hits length 30, a new box is needed.

	public PcBox(int boxId, String name, Trainer owner, List<OwnedPokemon> pokemon) {
		super();
		this.boxId = boxId;
		this.name = name;
		this.owner = owner;
		this.pokemon = pokemon;
	}

	public PcBox(String name, Trainer owner) {
		super();
		this.name = name;
		this.owner = owner;
		
		
	}

	public PcBox() {
		super();
	}

	public PcBox(String name, Trainer owner, List<OwnedPokemon> pokemon) {
		super();
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

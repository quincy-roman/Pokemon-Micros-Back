package com.pokemaster.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bag")
@Data
public class Bag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bag_id")
	private int bagId;
	
	@Column(name = "trainer")
	@OneToOne(cascade = CascadeType.ALL)
	private Trainer trainer;

	@ElementCollection
	@MapKeyColumn(name = "item")
	@Column(name = "frequency")
	@CollectionTable(name = "bagged_items", joinColumns = @JoinColumn(name = "items"))	// May need work.
	@OneToMany
	private Map<Item, Integer> items;	// Key will be the item, frequency is the value.

	public Bag(int bagId, Trainer trainer, Map<Item, Integer> items) {
		super();
		this.bagId = bagId;
		this.trainer = trainer;
		this.items = items;
	}
	
	// TODO
	
}

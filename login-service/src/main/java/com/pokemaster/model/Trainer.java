package com.pokemaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trainer")
@Data@NoArgsConstructor@AllArgsConstructor
public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trainer_id")
	private int trainerId;
	
	@Column(name = "name", nullable = false)
	private String name;	// Screen name.
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;	// Email address, main identification used for sign in.
	
	@Column(name = "password", nullable = false)
	private String password;	// TODO Spring Security.
	
	@Column(name = "poke", nullable = false, columnDefinition = "numeric default 0")
	private double poke;	// Currency for the application.

	public Trainer(String name, String email, String password, double poke) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.poke = poke;
	}
	
	// Add more here.

}

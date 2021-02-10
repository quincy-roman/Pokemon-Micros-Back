package com.pokemaster;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pokemaster.model.BasePokemon;
import com.pokemaster.model.Rarity;
import com.pokemaster.model.Trainer;
import com.pokemaster.model.Type;
import com.pokemaster.repository.BasePokemonRepository;
import com.pokemaster.service.GachaService;
import com.pokemaster.service.TrainerService;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	GachaService gachaServ;
	@Autowired
	BasePokemonRepository repo;

	@Autowired
	TrainerService tServ;

	static Logger log = Logger.getLogger(StartupApplicationListener.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		// USED TO AUTOPOPULATE DATABASE WITH POKEMON. USE ONLY WHEN THE DATABASE IS
		// PURGED OR BAD THINGS WILL HAPPEN!!!!!!
//	gachaServ.populateBasePokemonDatabase();

	}
}

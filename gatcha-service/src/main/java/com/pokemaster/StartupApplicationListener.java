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
import com.pokemaster.model.Type;
import com.pokemaster.repository.BasePokemonRepository;
import com.pokemaster.service.GachaService;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	GachaService gachaServ;
	@Autowired
	BasePokemonRepository repo;
	static Logger log = Logger.getLogger(StartupApplicationListener.class);
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
			
	//USED TO AUTOPOPULATE DATABASE WITH POKEMON. USE ONLY WHEN THE DATABASE IS PURGED OR BAD THINGS WILL HAPPEN!!!!!!
	//gachaServ.populateBasePokemonDatabase();
		
		
		
		
		List<BasePokemon> poke1 = gachaServ.rollGacha(10);
		for(BasePokemon p: poke1)
		{
			log.info(p.toString());
		}
		List<BasePokemon> poke2 = gachaServ.rollGacha(6);
		for(BasePokemon p: poke2)
		{
			log.info(p.toString());
		}
	}	
}

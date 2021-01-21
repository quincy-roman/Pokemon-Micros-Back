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
			
		//-------------		
		//Starts the periodic checking for new batches. Will run immediately on server start up, then weekly on the specified UpdateDay until the server is restarted.
		List<BasePokemon> list = new ArrayList<>();
		list.add(new BasePokemon(1,"Bulbasaur",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.COMMON,false));
		list.add(new BasePokemon(2,"Ivysaur",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.COMMON,false));
		list.add(new BasePokemon(3,"Venusaur",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.COMMON,false));
		list.add(new BasePokemon(4,"Charmander",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.COMMON,false));
		list.add(new BasePokemon(5,"Charmeleon",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.COMMON,false));
		list.add(new BasePokemon(6,"Charizard",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.COMMON,false));

		list.add(new BasePokemon(7,"Bulbasaur",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.UNCOMMON,false));
		list.add(new BasePokemon(8,"MEW",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.UNCOMMON,false));
		list.add(new BasePokemon(9,"Venusaur",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.UNCOMMON,false));
		list.add(new BasePokemon(10,"Charmander",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.UNCOMMON,false));
		list.add(new BasePokemon(11,"Charmeleon",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.UNCOMMON,false));
		list.add(new BasePokemon(12,"Charizard",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.UNCOMMON,false));
		
		list.add(new BasePokemon(13,"Bulbasaur",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.RARE,false));
		list.add(new BasePokemon(14,"RANDY",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.RARE,false));
		list.add(new BasePokemon(15,"Venusaur",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.RARE,false));
		list.add(new BasePokemon(16,"Charmander",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.RARE,false));
		list.add(new BasePokemon(17,"Charmeleon",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.RARE,false));
		list.add(new BasePokemon(18,"Charizard",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.RARE,false));
		
		list.add(new BasePokemon(19,"Bulbasaur",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.EPIC,false));
		list.add(new BasePokemon(20,"NOT_IVY",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.EPIC,false));
		list.add(new BasePokemon(21,"Venusaur",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.EPIC,false));
		list.add(new BasePokemon(22,"Charmander",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.EPIC,false));
		list.add(new BasePokemon(23,"Charmeleon",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.EPIC,false));
		list.add(new BasePokemon(24,"Charizard",Type.GRASS,Type.POISON,"chlrophyll",45,49,49,65,65,45,Rarity.EPIC,false));
		
		repo.saveAll(list);
		List<BasePokemon> poke = gachaServ.rollGacha(3);
		for(BasePokemon p: poke)
		{
			log.info(p.toString());
		}
		
		List<BasePokemon> poke1 = gachaServ.rollGacha(3);
		for(BasePokemon p: poke1)
		{
			log.info(p.toString());
		}
		List<BasePokemon> poke2 = gachaServ.rollGacha(3);
		for(BasePokemon p: poke2)
		{
			log.info(p.toString());
		}
	}	
}

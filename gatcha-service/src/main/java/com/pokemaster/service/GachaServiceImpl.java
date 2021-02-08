package com.pokemaster.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemaster.dto.PokemonDTO;
import com.pokemaster.model.BasePokemon;
import com.pokemaster.model.OwnedPokemon;
import com.pokemaster.model.Rarity;
import com.pokemaster.model.StarterPokemon;
import com.pokemaster.model.Status;
import com.pokemaster.model.Trainer;

@Service("gachaService")
public class GachaServiceImpl implements GachaService {

	private static Logger log = Logger.getLogger(GachaServiceImpl.class);

	@Autowired
	BasePokemonService basePokeServ;
	
	@Autowired
	OwnedPokemonService ownedServ;

	/***
	 * Returns a list of {@link BasePokemon} that is comprised of random pokemon
	 * Length of the list is the same as the numOfRolls 
	 */
	@Override
	public List<BasePokemon> rollGacha(int numOfRolls) {

		log.info("Rolling " + numOfRolls + " in GachaServiceImpl!");
		List<BasePokemon> rolledPokes = new ArrayList<>();
		for (int i = 0; i < numOfRolls; i++) {
			// Random % for rarity
			double rand = Math.random() * 100;
			// get the rarity
			Rarity r = evaluateRoll(rand);
			// randomly get pokemon based on rarity roll.
			BasePokemon pokemon = getRandomPokemon(r);
			rolledPokes.add(pokemon);

		}
		return rolledPokes;
	}

	/***
	 * Returns {@link Rarity} based on the provided double.
	 */
	@Override
	public Rarity evaluateRoll(double roll) {
		if (roll <= MYTHIC_DROP_RATE) {
			return Rarity.MYTHIC;
		} else if (roll <= LEGENDARY_DROP_RATE) {
			return Rarity.LEGENDARY;
		} else if (roll <= RARE_DROP_RATE) {
			return Rarity.RARE;
		} else if (roll <= UNCOMMON_DROP_RATE) {
			return Rarity.UNCOMMON;
		} else {
			return Rarity.COMMON;

		}
	}

	/***
	 * Returns a random {@link BasePokemon} from the specified rarity
	 */
	@Override
	public BasePokemon getRandomPokemon(Rarity rarity) {
		//Get all pokemon
		List<BasePokemon> foundPokemon = basePokeServ.findWithRarity(rarity);
		log.info("Size of foundPokemon is: " +foundPokemon.size());
		int rand = (int) (Math.random() * (foundPokemon.size() - 1));
		log.info("Random value is: " + rand);
		return foundPokemon.get(rand);
	}

	
	@Override
	public List<OwnedPokemon> assignGacha(Trainer trainer, List<BasePokemon> basePoke) {
		// TODO Auto-generated method stub		
		List<OwnedPokemon> ownedPoke = new ArrayList<>();
		for(BasePokemon p : basePoke) {
			//Convert BasePokemon to a new owned Pokemon
			ownedPoke.add(new OwnedPokemon(0,p.getSPECIES(),"",trainer,trainer,p.getTYPE_ONE(),p.getTYPE_TWO()
					,p.getABILITY(),Status.NONE,p.getMAX_HP(),p.getMAX_HP()
					,p.getATK(),p.getDEF(),p.getSPATK(),p.getSPDEF()
					,p.getSPD(),p.getRarity(),false,false ));
		}
		
		return ownedServ.saveAll(ownedPoke);
	}

	@Override
	public List<BasePokemon> rollStarterGacha(Trainer trainer) {
		
		//generates 6 starting pokemon with 1 being a starter pokemon, and the remaining 5 being rare or lower.
		List<BasePokemon> poke = new ArrayList<>();
		//Get random starter from starter enum
		poke.add(basePokeServ.findById(StarterPokemon.randomStarter().getPokeId()));
		
		for(int i =0; i < 2; i++)
		{
			poke.add(getRandomPokemon(Rarity.UNCOMMON));
		}
		for(int i =0; i < 2; i++)
		{
			poke.add(getRandomPokemon(Rarity.COMMON));
		}
		poke.add(rollGacha(1).get(0));
		
		
		return poke;
	}

	@Override
	public void populateBasePokemonDatabase() {
		//Open file for reading
		File file = new File(this.getClass().getClassLoader().getResource("Poke.txt").getFile());
		BufferedReader br = null;
		try
		{
			//Read file, and store to string builder
			br = new BufferedReader(new FileReader(file));
			String line;
			StringBuilder sb = new StringBuilder();
			List<PokemonDTO> list = new ArrayList<>();
			while((line = br.readLine()) !=null)
			{
				//Appends for debugging.
				sb.append(line);
				
				ObjectMapper mapper = new ObjectMapper();
				list.add(mapper.readValue(line,PokemonDTO.class)) ;

				
				
			}
			log.info(sb.toString());
			//Parse string builder with Jackson
			
			List<BasePokemon> list2 = new ArrayList<>();
			for(PokemonDTO poke : list)
			{
				list2.add(poke.convertToBasePokemon());
			}
			
			basePokeServ.saveAll(list2);
			
			log.info("Saved all pokemon to DB");
			
		}catch(IOException ioE)
		{
			ioE.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			if(br !=null)
			{
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		}
		
		
		
		
		
	}




	
}

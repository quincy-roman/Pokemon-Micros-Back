package com.pokemaster.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemaster.model.BasePokemon;
import com.pokemaster.model.OwnedPokemon;
import com.pokemaster.model.Trainer;
import com.pokemaster.repository.BasePokemonRepository;
import com.pokemaster.repository.OwnedPokemonRepository;

@Service
public class OwnedPokemonService {

	@Autowired
	BasePokemonRepository bpRepository;
	
	@Autowired
	OwnedPokemonRepository opRepository;
	
	public void initOwnedPokemon(int number, int trainerId) {
		List<OwnedPokemon> ownedPokemon = new ArrayList<>();
		for (int i=1; i <= number; i++) {
			BasePokemon p = bpRepository.findById(i).get();
			ownedPokemon.add(new OwnedPokemon(0,p.getSPECIES(),"",new Trainer(trainerId), new Trainer(trainerId),p.getTYPE_ONE(),p.getTYPE_TWO()
					,p.getABILITY(),null,p.getMAX_HP(),p.getMAX_HP()
					,p.getATK(),p.getDEF(),p.getSPATK(),p.getSPDEF()
					,p.getSPD(),p.getRarity(),false,false ));
		}
		opRepository.saveAll(ownedPokemon);
	}
	
}

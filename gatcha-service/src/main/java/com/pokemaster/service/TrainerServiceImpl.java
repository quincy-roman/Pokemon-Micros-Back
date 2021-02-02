package com.pokemaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemaster.model.Trainer;
import com.pokemaster.repository.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	TrainerRepository trainerRepo;
	
	@Override
	public List<Trainer> findAll() {
		// TODO Auto-generated method stub
		return trainerRepo.findAll();
	}

	@Override
	public Trainer findTrainerById(int id) {
		// TODO Auto-generated method stub
		return trainerRepo.findById(id).get();
	}

	@Override
	public int saveTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		return trainerRepo.save(trainer).getTrainerId();
	}

	

}

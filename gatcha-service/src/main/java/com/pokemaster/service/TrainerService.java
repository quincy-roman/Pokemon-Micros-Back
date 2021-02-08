package com.pokemaster.service;

import java.util.List;

import com.pokemaster.model.Trainer;

public interface TrainerService {

	public List<Trainer> findAll();

	public Trainer findTrainerById(int id);

	public int saveTrainer(Trainer trainer);

}

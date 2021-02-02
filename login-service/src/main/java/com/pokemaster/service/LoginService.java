package com.pokemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemaster.model.Trainer;
import com.pokemaster.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepo;

	public Integer checkCreds(String email, String password) {

		Trainer t = loginRepo.findByEmailAndPassword(email, password);

		return t.getTrainerId();
	}

	public Integer register(Trainer trainer) {

		loginRepo.save(trainer);

		return trainer.getTrainerId();
	}
	
	public Trainer findTrainerById(int id)
	{
		return loginRepo.findById(id).get();
	}

}

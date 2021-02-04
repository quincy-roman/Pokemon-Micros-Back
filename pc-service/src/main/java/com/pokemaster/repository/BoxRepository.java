package com.pokemaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemaster.model.PcBox;
import com.pokemaster.model.Trainer;

@Repository
public interface BoxRepository  extends JpaRepository<PcBox, Integer>{

	List<PcBox> findAllByOwner(Trainer owner);
}

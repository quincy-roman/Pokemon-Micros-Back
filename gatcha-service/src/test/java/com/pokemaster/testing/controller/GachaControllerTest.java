package com.pokemaster.testing.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemaster.controller.GachaController;
import com.pokemaster.service.BasePokemonService;
import com.pokemaster.service.GachaService;
import com.pokemaster.service.TrainerService;

@WebMvcTest(GachaController.class)
public class GachaControllerTest {
	
	ObjectMapper mapper = new ObjectMapper();
	
	@MockBean
	private GachaService gachaService;
	
	@MockBean
	private BasePokemonService pokemonService;
	
	@MockBean
	private TrainerService trainerService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private GachaController gachaController;
	
	// Ensure the application context is loaded.
	@Test
	public void contextLoads() throws Exception{
		assertThat(gachaController).isNotNull();
	}
	
	@Test
	public void verifyRollGacha() throws Exception{
		// I have no idea where to begin.
	}
	
	@Test
	public void failRollGacha() throws Exception{
		// TODO
	}

}

package com.pokemaster.testing.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemaster.controller.LoginController;
import com.pokemaster.model.Trainer;
import com.pokemaster.service.LoginService;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {
	
	ObjectMapper mapper = new ObjectMapper();
	
	@MockBean
	private LoginService loginService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private LoginController loginController;
	
	
	/*
	 * Ensure the application context is loaded.
	 * If not, all tests should and will fail.
	 */
	@Test
	public void contextLoads() throws Exception{
		assertThat(loginController).isNotNull();
	}
	
	@Test
	public void verifyLogin() throws Exception{
		
		List<Trainer> trainers = new ArrayList<>();
		
		trainers.add(new Trainer(1, "Test", "test@mail.com", "testpass", 500));
		trainers.add(new Trainer(2, "Ash", "ash@mail.com", "pikachu", 10_000));
		trainers.add(new Trainer(3, "Cynthia", "champ@sinnoh.net", "garchomp", 999_999_999));
		
		// Make a test trainer with just an email and password.
		Trainer loginTrainer = new Trainer();
		loginTrainer.setEmail("test@mail.com");
		loginTrainer.setPassword("testpass");
		
		// Shows that when LoginService is called, what it should return.
		when(loginService.checkCreds(loginTrainer.getEmail(), loginTrainer.getPassword())).thenReturn(trainers.get(0).getTrainerId());
		
		this.mockMvc.perform(post("/login")
							 .contentType("application/json")
							 .content(mapper.writeValueAsString(loginTrainer)))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType("application/json"))
					.andExpect(content().string("1"));
		
	}

}

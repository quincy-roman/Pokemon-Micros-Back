package com.pokemaster.testing.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.pokemaster.controller.LoginController;
import com.pokemaster.model.Trainer;
import com.pokemaster.service.LoginService;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {
	
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
		
		when(loginService.checkCreds(trainers.get(0).getEmail(), trainers.get(0).getPassword())).thenReturn(trainers.get(0).getTrainerId());
		
		this.mockMvc.perform(post("/login")
							 .param("email", "Test")
							 .param("password", "testpass"))
					.andDo(print())
					.andExpect(status().isOk())
//					.andExpect(content().contentType("application/json;charset=UTF-8"))
					.andExpect(jsonPath("$.id").value(1));
		
	}

}

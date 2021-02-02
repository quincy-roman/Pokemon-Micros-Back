package com.pokemaster.testing.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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
	
	private List<Trainer> trainers;
	
	/*
	 * A basic list of trainers that are filled with
	 * dummy data for testing purposes.
	 */
	@BeforeEach
	public void init() {
		trainers = new ArrayList<>();
		trainers.add(new Trainer(1, "Test", "test@mail.com", "testpass", 500));
		trainers.add(new Trainer(2, "Ash", "ash@mail.com", "pikachu", 10_000));
		trainers.add(new Trainer(3, "Cynthia", "champ@sinnoh.net", "garchomp", 999_999_999));
	}
	
	
	/*
	 * Ensure the application context is loaded.
	 * If not, all tests should and will fail.
	 */
	@Test
	public void contextLoads() throws Exception{
		assertThat(loginController).isNotNull();
	}
	
	/*
	 * Tests to show that the loginTrainer() function
	 * operates as expected in the LoginController.
	 * As this only tests the controller, the response
	 * is coded as if the Service method was successful.
	 */
	@Test
	public void verifyLogin() throws Exception{
		
		int pos = 0;
		
		// Show that logging in with the established trainers works properly.
		for(Trainer trainer : trainers) {
			when(loginService.checkCreds(trainer.getEmail(), trainer.getPassword())).thenReturn(trainers.get(pos).getTrainerId());
			
			this.mockMvc.perform(post("/login")
								.contentType("application/json")
								.content(mapper.writeValueAsString(trainer)))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(content().contentType("application/json"))
						.andExpect(content().string(mapper.writeValueAsString(trainer.getTrainerId())));
			
			pos++;
		}		
	}
	
	/*
	 * Test with improper login credentials.
	 * If a user is not found within the database,
	 * the returned id should be null.
	 * In the controller, a null id should return a 
	 * 400 BAD_REQUEST status.
	 */
	@Test
	public void failLogin() throws Exception{
		
		// Show that logging in with random information will not work.
		Trainer failure = new Trainer(0, "fail", "", "", 0);

		// For this service method, a null value is returned as the id of the returned trainer.
		when(loginService.checkCreds(failure.getEmail(), failure.getPassword())).thenReturn(null);

		// If the id is null, a 400 response is sent.
		this.mockMvc.perform(post("/login")
							 .contentType("application/json")
							 .content(mapper.writeValueAsString(failure)))
					.andDo(print())
					.andExpect(status().isBadRequest());
		
	}
	
	/*
	 * Test that registration returns the CREATED status
	 * that it should if successful. Each trainer in the
	 * trainers list will be tested.
	 * The method should accept JSON data as a variable
	 * and return the newly created URI.
	 */
	@Test
	public void verifyRegistration() throws Exception{
		
		for(Trainer trainer : trainers) {
			
			when(loginService.register(trainer)).thenReturn(trainer.getTrainerId());
			
			this.mockMvc.perform(post("/login/register")
					.contentType("application/json")
					.content(mapper.writeValueAsBytes(trainer)))
			.andDo(print())
			.andExpect(status().isCreated());
		}
		
	}
	
	/*
	 * Test what happens if registration fails.
	 * A null primary key from the service layer denotes
	 * that the transaction was unsuccessful, the result
	 * should be a BAD_REQUEST.
	 * The method accepts JSON data as a variable.
	 */
	@Test
	public void failRegistration() throws Exception{
		
		Trainer trainer = trainers.get(0);
			
		when(loginService.register(trainer)).thenReturn(null);
		
		this.mockMvc.perform(post("/login/register")
				.contentType("application/json")
				.content(mapper.writeValueAsBytes(trainer)))
		.andDo(print())
		.andExpect(status().isBadRequest());
	}
		

}


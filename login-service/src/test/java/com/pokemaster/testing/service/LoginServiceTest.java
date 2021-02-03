package com.pokemaster.testing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pokemaster.model.Trainer;
import com.pokemaster.repository.LoginRepository;
import com.pokemaster.service.LoginService;

@SpringBootTest
public class LoginServiceTest {
	
	@MockBean
	private LoginRepository repo;
	
	@Autowired
	private LoginService service;
	
	private Trainer trainer;
	
	@BeforeEach
	public void init() {
		this.service = new LoginService();
		this.trainer = new Trainer("Mock Mockito", "mock@mocker.mock", "mockingjay", 600_600);
	}
	
	/*
	 * Test the fact that registration is called.
	 * Needs work, but there isn't exactly much to test.
	 */
	@Test@Disabled
	public void registerSuccess() {
		
		when(repo.save(trainer)).thenReturn(new Trainer());
		
		int created = service.register(trainer);
		
		assertThat(trainer.getTrainerId()).isNotEqualTo(created);
	}
	
	/*
	 * Test all the different ways that registration may fail.
	 * The Trainer class has five fields, four with a NOT NULL
	 * constraint.
	 * If so much as one of these fields is null or has no value
	 * assigned, a NullPointerException will be thrown.
	 */
	@Test
	public void registerFail() {
		
		// A null object is not excepted.
		Assertions.assertThrows(NullPointerException.class, () -> {
			service.register(null);			
		});
		
		// An object with null fields is not accepted.
		Assertions.assertThrows(NullPointerException.class, () -> {
			service.register(new Trainer());
		});
		
		Trainer incomplete = new Trainer();
		incomplete.setEmail("email@set.com");
		
		// An object with any null fields is not accepted.
		Assertions.assertThrows(NullPointerException.class, () -> {
			service.register(incomplete);
		});
	}

}

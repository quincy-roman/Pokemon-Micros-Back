package com.pokemaster.controller;

import java.net.URI;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemaster.model.Trainer;
import com.pokemaster.service.LoginService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/login")
public class LoginController {

	private static Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	/*
	 * Login as an existing trainer. Receives an email and password from the front
	 * end as Strings. Returns an OK status with the id of the user or a BAD_REQUEST
	 * if the Trainer is not found.
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> loginTrainer(@RequestBody Trainer trainer) {

		Integer id = loginService.checkCreds(trainer.getEmail(), trainer.getPassword());
		if (id != null) {
			return ResponseEntity.ok(id); // Might need to return the entire Trainer.
		}

		log.warn("Username or password incorrect.");
		return ResponseEntity.badRequest().build();
	}

	/*
	 * Register a new Trainer. Takes a Trainer with all fields as a JSON object.
	 * Returns a CREATED status with the new URI or a BAD_REQUEST if the
	 * registration failed.
	 */
	@PostMapping(path = "/register", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Integer> registerTrainer(@RequestBody Trainer trainer) {
		Integer id = loginService.register(trainer);
		log.info(id);
		if (id != null) {
//			ResponseEntity<Integer> ret = ResponseEntity.ok(id);
//			return ret;
			return ResponseEntity.created(URI.create("/trainer/" + id)).build();
		}

		log.warn("Registration failed.");
		return ResponseEntity.badRequest().build();
	}

	/*
	 * GET an existing Trainer by their unique ID.
	 * The ID is taken from the URL as a PathVariable.
	 * 404 NOT_FOUND is sent if the Trainer is not found,
	 * 200 OK with the Trainer as JSON is sent if found.
	 */
	@GetMapping(path = "/trainer/{id}")
	public ResponseEntity<Trainer> getTrainer(@PathVariable("id") int id) {
		Trainer t = loginService.findTrainerById(id);
		
		if(t == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(t);
	}

}

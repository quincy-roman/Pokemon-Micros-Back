package com.pokemaster.PokemonMicroservices;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pokemaster.PokemonMicroservices.util.RabbitMQReceiver;

/** NOTE: DO NOT TOUCH THIS CLASS!
 * This Runner class will serve as a RabbitMQ tester class until 
 * the overall project service-notification functionality is complete.
 * 
 * @author Azhya Knox
 */

@Component
public class Runner implements CommandLineRunner {

	private final RabbitTemplate rabbitTemplate;
	private final RabbitMQReceiver receiver;

	public Runner(RabbitMQReceiver receiver, RabbitTemplate rabbitTemplate) {
		this.receiver = receiver;
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending message...");
		if(args[0].equals("--spring.output.ansi.enabled=always")) {
			rabbitTemplate.convertAndSend(PokemonMicroservicesApplication.topicExchangeName, "pokemon.microservice.messager", "Hello from RabbitMQ!");
		    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		}else {
			rabbitTemplate.convertAndSend(PokemonMicroservicesApplication.topicExchangeName, "pokemon.microservice.messager", args[0]);
			receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		}
	}

}

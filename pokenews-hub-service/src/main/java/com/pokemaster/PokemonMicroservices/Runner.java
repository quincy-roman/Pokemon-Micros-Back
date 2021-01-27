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
	    rabbitTemplate.convertAndSend(PokemonMicroservicesApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
	    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	    rabbitTemplate.convertAndSend(PokemonMicroservicesApplication.topicExchangeName, "foo.bar.baz", "This is my first CUSTOM RabbitMQ message!");
	    receiver.getLatch().await(5000, TimeUnit.MILLISECONDS);
	}

}

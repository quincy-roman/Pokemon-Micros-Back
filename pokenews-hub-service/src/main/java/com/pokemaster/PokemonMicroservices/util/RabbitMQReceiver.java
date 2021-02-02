package com.pokemaster.PokemonMicroservices.util;

import org.apache.log4j.Logger;
import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

/**
 *  The Receiver is a POJO that defines a method for receiving messages. 
 *  When you register it to receive messages, you can name it anything you want. 
 *  For convenience, this POJO also has a CountDownLatch. 
 *  This lets it signal that the message has been received. 
 *  This is something you are not likely to implement in a production application.
 *  
 *  Read more at: https://spring.io/guides/gs/messaging-rabbitmq/#scratch
 * 
 * 
 * @author Azhya Knox
 */

@Component
public class RabbitMQReceiver {

	private CountDownLatch latch = new CountDownLatch(1);
	private static Logger logger = Logger.getLogger(RabbitMQReceiver.class);

	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}

package org.springframework.amqp.tutorials.rabbitmqamqptutorials;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqAmqpTutorialsApplication {


    @Profile("usage_message")
	@Bean
	public CommandLineRunner usage(){
		return args -> {
			System.out.println("Using spring profiles to control behavior.\n");
			System.out.println("Sample usage: java -jar\n" +
					"                rabbit-tutorials.jar\n" +
					"                --spring.profiles.active=hello-world,sender");
		};
	}

	@Profile("!usage_message")
	@Bean
	public CommandLineRunner tutorial(){
		return new RabbitAmqpTutorialsRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqAmqpTutorialsApplication.class, args);
	}

}


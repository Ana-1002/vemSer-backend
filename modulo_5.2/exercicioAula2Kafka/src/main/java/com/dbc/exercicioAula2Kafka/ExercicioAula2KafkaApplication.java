package com.dbc.exercicioAula2Kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ExercicioAula2KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercicioAula2KafkaApplication.class, args);
	}

}

package br.dev.marcoalmeida.fileaxemongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"br.dev.marcoalmeida.fileaxemongo"})
public class FileAxeMongoApplication {
	public static void main(String[] args) {
		SpringApplication.run(FileAxeMongoApplication.class, args);
	}

}

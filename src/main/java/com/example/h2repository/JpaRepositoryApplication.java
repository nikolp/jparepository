package com.example.h2repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class JpaRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaRepositoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MDFileRepository repository, Environment environment) {
		return args -> {
			String url = environment.getProperty("spring.datasource.url");
			MDFile f1 = new MDFile(1L, "123", "fileA", "Hello World");
			repository.save(f1);
		};
	}

}

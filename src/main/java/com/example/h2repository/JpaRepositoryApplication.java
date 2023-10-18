package com.example.h2repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
@Slf4j
public class JpaRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaRepositoryApplication.class, args);
	}

	// Note this runs during unit tests, but then it creates on the fly h2 connection like
	// HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:78244631-37d6-476c-aad5-408f1873fadf user=SA
	@Bean
	public CommandLineRunner demo(MDFileRepository repository, Environment environment) {
		return args -> {
			ZonedDateTime zdt = ZonedDateTime.now();
			MDFile f1 = MDFile.builder()
					.mdId("123")
					.fileName("fileA")
					.contents("Hello World")
					.updateTime(zdt)
					.build();
			repository.save(f1);

			List<MDFile> readResult = repository.findByUpdateTime(zdt);
			log.info(readResult.get(0).toString());

			String url = environment.getProperty("spring.datasource.url", "");
			// url == "" in unit tests which do not look at any db-specific profile
			if (url.contains("jdbc:h2:mem:")) {
				log.info("Waiting for you to examine in-memory database, stop process manually when done.");
				Thread.sleep(10 * 60 * 1000);
			}
		};
	}

}

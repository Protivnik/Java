package Alteration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Pp8Application {

	public static void main(String[] args) {
		SpringApplication.run(Pp8Application.class, args);
	}

}

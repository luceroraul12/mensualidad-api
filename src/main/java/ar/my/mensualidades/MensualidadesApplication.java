package ar.my.mensualidades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
public class MensualidadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensualidadesApplication.class, args);
	}

}

package ma.cigma.springbootclientmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		System.out.println("Application démarrée");
	}
/*
 * L'annotation @Bean permet à Spring d'injecter au besoin l'objet qui est le resultat de la méthode
 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}

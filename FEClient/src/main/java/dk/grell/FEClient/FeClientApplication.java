package dk.grell.FEClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeClientApplication {

	
	// Opstart af FEClient webserver
	public static void main(String[] args) {
		System.out.println("Entering FEClient.main...");
		SpringApplication.run(FeClientApplication.class, args);		
	}

}

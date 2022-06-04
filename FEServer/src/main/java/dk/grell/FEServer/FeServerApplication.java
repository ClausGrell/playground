package dk.grell.FEServer;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FeServerApplication {

	private static String encryptKey = "S0mmerhat!";
    
    // Opstart af FEServer server
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Entering FeServerApplication.main...");
		SpringApplication.run(FeServerApplication.class, args);
		
		// set vEncodedDateTime i klassen ServerController hvert min med aktuel dato og tid (krypteret).
		while (true) {
			ServerController.vEncodedDateTime = AES.encrypt(getCurrentDateTime(), encryptKey);;			
			Thread.sleep(1000 * 60); // pause i 60 sek.
		}
	}
	
	
	// Hent aktuel dato og tid og krypter.
    public static String getCurrentDateTime() {
    	System.out.println("Entering FeServerApplication.getCurrentDateTime()...");
    	String vDateTime="";
    	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		Date date = new Date(System.currentTimeMillis());
		vDateTime = formatter.format(date);					
    	return vDateTime;	
    }

}
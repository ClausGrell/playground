package dk.grell.FEClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
public class ClientController {

	Logger filelogger = new Logger();
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
		 
	// Håndtering af GET requests
	@GetMapping("/client")
	public String doGet() {
		System.out.println("Entering ClientController.doGet...");
		String encryptedDate="";
		String decryptedDate="";
		
		// Hent krypteret dato fra FEServer
		try {
			encryptedDate = ServerRequest.getStringFromURL("http://grell.dk:8192/server");
			decryptedDate = AES.decrypt(encryptedDate,"S0mmerhat!");
			filelogger.log("doGet() - " + encryptedDate + " -> " + decryptedDate);
			logger.info("doGet() - " + encryptedDate + " -> " + decryptedDate);
		} catch (IOException e) {
			encryptedDate = "NA";
			e.printStackTrace();
		} catch (InterruptedException e) {
			encryptedDate = "NA";
			e.printStackTrace();
		}
		
		
		// Find antal sekunder til næste opdatering af GUI/Client
		Random rn = new Random();
		int secondsToUpdate = rn.nextInt(30) + 1;
		System.out.println("secondsToUpdate=" + String.valueOf(secondsToUpdate));
		
		// Generer html til client.
		String returnStr = 
		 "<html>\r\n"
				+ "  <head>\r\n"
				+ "    <title>Client (date/time)</title>\r\n"
				+ "    <meta http-equiv=\"refresh\" content=\"" + String.valueOf(secondsToUpdate)+ "\" />\r\n"
				+ "  </head>\r\n"
				+ "  <body>\r\n"
				+ "Current date and time is:" + decryptedDate
				+ "<br>"
				+ "Next update in " + String.valueOf(secondsToUpdate) + " seconds"
				+ "  </body>\r\n"
				+ "</html>";
		return returnStr;
				
				
	}
	
	
}

package dk.grell.FEServer;



import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

	public static String  eDate;	
	public static String vEncodedDateTime = "";
	private Logger filelogger = new Logger();
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());	 

	
	// Håndtering af GET requests
	@GetMapping("/server")
	public String getEncodedDateTime() {
		System.out.println("Entering ServerController.getEncodedDateTime()...");	
		filelogger.log("/server - returning " + vEncodedDateTime);
		logger.info("/server - returning " + vEncodedDateTime);
		return vEncodedDateTime; 
	}
	
	
}

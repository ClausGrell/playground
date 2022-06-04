package dk.grell.FEServer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
		
	// Indsætter log i filen FEServer.log
	public void log(String pStr) {		
    	String vDateTime="";
    	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		Date date = new Date(System.currentTimeMillis());
		vDateTime = formatter.format(date);		
		
        try (FileWriter filewriter = new FileWriter("FEServer.log", true);
            BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
            PrintWriter printwriter = new PrintWriter(bufferedwriter);) {
        	printwriter.println(vDateTime + ": " + pStr);

        } catch (IOException i) {
            i.printStackTrace();
        }
	}

}

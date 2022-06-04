package dk.grell.FEClient;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class ServerRequest {
	
	
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    
    
	// Hent response fra URL-request.
	public static String getStringFromURL(String pURL)  throws IOException, InterruptedException {
		System.out.println("Entering FEClient.getStringFromURL (" + pURL + ")...");

		HttpRequest request = HttpRequest.newBuilder()
				.GET()
                .uri(URI.create(pURL))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") 
                .build();
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("response.statusCode()=" + response.statusCode());
		System.out.println("response.body()=" + response.body());
		 
		return response.body();
	}

}
package api.api_calls;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Paths;


public class Api {
	String url;
	String username;
	String api_key;
	String action;
	String file;

	public Api(String url, String api_key, String action) {
		this.url = url;
		this.api_key = api_key;
		this.action = action;
	}

	public Api(String url, String api_key, String action, String file) {
		this.url = url;
		this.api_key = api_key;
		this.action = action;
		this.file = file;
	}

	// API GET
	public String api_get() throws Exception {
		try {

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(URI.create(this.url))
					.header("Authorization", "Key " + this.api_key).build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			return response.body();

		} catch (Exception e) {
			throw new Exception("API ERROR: " + e);
		}
	}

	// API POST
	public String api_post() throws FileNotFoundException, IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder(URI.create(this.url))
				.header("Authorization", "Key " + this.api_key).header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofFile(Paths.get(this.file))).build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response.body();
	}

	public String getUrl() {
		return this.url;
	}

	public String getAction() {
		return this.action;
	}
}

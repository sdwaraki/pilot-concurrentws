package com.sumanth.projects.pilotconcurrentws;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PilotConcurrentwsApplication {

	public static void main(String[] args) throws UnsupportedOperationException, IOException {
		SpringApplication.run(PilotConcurrentwsApplication.class, args);
		//System.out.println(newsResponse());
	}
	
	
	public static String newsResponse() throws UnsupportedOperationException, IOException {
		String SAMPLE_URL = "https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=a06d41397efd41baa6a8746be9155af7";
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response;
		try {
		response = client.execute(new HttpGet(SAMPLE_URL));
		}
		catch(Exception e) {
			System.out.println("Error received in the WS call " + e.getStackTrace());
			return "Error";
		}
		return EntityUtils.toString(response.getEntity(), "UTF-8");
	}

}

package com.sumanth.projects.pilotconcurrentws.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sumanth.projects.pilotconcurrentws.rest.NewsAPIResponse;

public class CallNewsApiServiceImpl implements CallNewsApiService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ExecutorBean executor;

	@Value("${api.key}")
	private String apiKey;

	@Value("${base.url}")
	private String baseUrl;

	@Value("${api.path}")
	private String path;

	@Override
	public CompletableFuture<NewsAPIResponse> getNews(String source, String query) throws URISyntaxException {
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme("https");
		uriBuilder.setHost(baseUrl);
		uriBuilder.setPath(path);
		uriBuilder.addParameter("q", query);
		uriBuilder.addParameter("apiKey", apiKey);
		uriBuilder.addParameter("pageSize", "10");
		uriBuilder.addParameter("sources", source);
		CompletableFuture<NewsAPIResponse> response = null;
		
		URI u = uriBuilder.build();
		response = CompletableFuture.supplyAsync(() -> {
			ResponseEntity<NewsAPIResponse> respEntity = restTemplate.getForEntity(u, NewsAPIResponse.class);
			NewsAPIResponse resp = respEntity.getBody();
			return resp;
		}, executor.getExecutor());
		return response;
	}
}

package com.sumanth.projects.pilotconcurrentws.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.sumanth.projects.pilotconcurrentws.rest.NewsAPIResponse;

public class CallNewsApiServiceImpl implements CallNewsApiService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ExecutorBean executor;

	@Override
	public CompletableFuture<NewsAPIResponse> getNews(String source) {
		return null;
	}
	
}

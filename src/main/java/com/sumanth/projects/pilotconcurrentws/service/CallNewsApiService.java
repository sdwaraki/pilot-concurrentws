package com.sumanth.projects.pilotconcurrentws.service;

import java.util.concurrent.CompletableFuture;

import com.sumanth.projects.pilotconcurrentws.rest.NewsAPIResponse;

public interface CallNewsApiService {

	public CompletableFuture<NewsAPIResponse> getNews(String source);
	
}

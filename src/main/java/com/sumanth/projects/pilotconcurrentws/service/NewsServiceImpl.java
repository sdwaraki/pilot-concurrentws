package com.sumanth.projects.pilotconcurrentws.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.sumanth.projects.pilotconcurrentws.model.Article;
import com.sumanth.projects.pilotconcurrentws.rest.NewsAPIResponse;
import com.sumanth.projects.pilotconcurrentws.rest.NewsResponse;

public class NewsServiceImpl implements NewsService {
	
	@Autowired
	CallNewsApiService callNewsApiService;

	@Override
	public NewsResponse getNewsBySource(List<String> sources) {
		List<CompletableFuture<NewsAPIResponse>> futures = sources.stream().map(s -> callNewsApiService.getNews(s)).collect(Collectors.toList());
		List<NewsAPIResponse> responses = futures.stream().map(r -> r.join()).collect(Collectors.toList());
		return convertAPIResponsesToNewsResponse(responses);
 	}
	
	public NewsResponse convertAPIResponsesToNewsResponse(List<NewsAPIResponse> apiResponse) {
		NewsResponse response = new NewsResponse();
		String status = apiResponse.size()>0?"OK":"Error";
		List<Article> combinedArticleList = Lists.newArrayList();
		for(NewsAPIResponse res: apiResponse) {
			List<Article> arList = Stream.of(res.getArticles()).collect(Collectors.toList());
			combinedArticleList.addAll(arList);
		}
		response.setStatus(status);
		response.setArticles((Article[]) combinedArticleList.toArray());
		return response;
	}

}

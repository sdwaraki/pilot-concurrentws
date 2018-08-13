package com.sumanth.projects.pilotconcurrentws.service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
		List<NewsAPIResponse> responses = Lists.newArrayList();
		String queryTerm = getRandomQueryString();
		List<CompletableFuture<NewsAPIResponse>> futures = sources.stream().map(s -> {
			try {
				return callNewsApiService.getNews(s, queryTerm);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
		responses = futures.stream().map(r -> r.join()).collect(Collectors.toList());
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
	
	public String getRandomQueryString() {
		List<String> queryTermList = new ArrayList<String>();
		queryTermList.add("Bitcoin");
		queryTermList.add("Drake");
		queryTermList.add("Amazon");
		queryTermList.add("Trump");
		queryTermList.add("Samsung");
		Integer totalSize = queryTermList.size();
		Random r = new Random();
		Integer index = r.nextInt(totalSize);
		return queryTermList.get(index);
	}

}

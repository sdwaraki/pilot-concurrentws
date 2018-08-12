package com.sumanth.projects.pilotconcurrentws.rest;

import com.sumanth.projects.pilotconcurrentws.model.Article;

public class NewsAPIResponse {
	
	private String status;
	
	private Integer totalResults;
	
	private Article[] articles;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	public Article[] getArticles() {
		return articles;
	}

	public void setArticles(Article[] articles) {
		this.articles = articles;
	}

}

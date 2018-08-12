package com.sumanth.projects.pilotconcurrentws.rest;

import com.sumanth.projects.pilotconcurrentws.model.Article;

public class NewsResponse {
	
	private String status;
	
	private Article[] articles;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Article[] getArticles() {
		return articles;
	}

	public void setArticles(Article[] articles) {
		this.articles = articles;
	}
	
}

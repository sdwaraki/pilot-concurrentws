package com.sumanth.projects.pilotconcurrentws.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sumanth.projects.pilotconcurrentws.model.Article;

public class NewsAPIResponse {
	
	private Integer status;
	
	private String st;
	
	private Integer totalResults;
	
	private Article[] articles;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

}

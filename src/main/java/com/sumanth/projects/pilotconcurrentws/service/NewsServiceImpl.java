package com.sumanth.projects.pilotconcurrentws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sumanth.projects.pilotconcurrentws.rest.NewsResponse;

public class NewsServiceImpl implements NewsService {
	
	@Autowired 
	ExecutorBean executor;

	@Override
	public NewsResponse getNewsBySource(List<String> sources) {
		//
		return null;
	}

}

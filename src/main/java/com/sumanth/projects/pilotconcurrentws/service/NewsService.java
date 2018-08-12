package com.sumanth.projects.pilotconcurrentws.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sumanth.projects.pilotconcurrentws.rest.NewsResponse;

@Service
public interface NewsService {
		
	public NewsResponse getNewsBySource(List<String> sources);
	
}

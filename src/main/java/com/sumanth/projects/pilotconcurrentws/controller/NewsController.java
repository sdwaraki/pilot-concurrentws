package com.sumanth.projects.pilotconcurrentws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sumanth.projects.pilotconcurrentws.rest.NewsResponse;
import com.sumanth.projects.pilotconcurrentws.service.NewsService;

@RestController
@RequestMapping(value="/news")
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	@RequestMapping(value="/get/{sources}", method=RequestMethod.GET)
	public NewsResponse getNews(@PathVariable List<String> sources) {
		return newsService.getNewsBySource(sources);
	}

}

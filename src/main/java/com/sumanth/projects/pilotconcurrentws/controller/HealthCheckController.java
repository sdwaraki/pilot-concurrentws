package com.sumanth.projects.pilotconcurrentws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/health")
	public String health() {
		return "Webservice is healthy";
	}
}

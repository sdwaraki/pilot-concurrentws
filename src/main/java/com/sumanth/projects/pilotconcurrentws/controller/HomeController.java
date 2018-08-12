package com.sumanth.projects.pilotconcurrentws.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@PropertySource("classpath:application.properties")
public class HomeController {
	
	@Value("${api.key}")
	private String apiKey;
	
	@Value("${base.url}")
	private String baseUrl;
	
	@Value("${api.params}")
	private String parameters;

	@RequestMapping(value="/details", method=RequestMethod.GET, produces="application/json")
	public Map<String, String> getDetails() {
		Map<String, String> details = new HashMap<String, String>();
		details.put("apiKey", apiKey);
		details.put("baseUrl", baseUrl);
		details.put("params", parameters);
		return details;
	}
}

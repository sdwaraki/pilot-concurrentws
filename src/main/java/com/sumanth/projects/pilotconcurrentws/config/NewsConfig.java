package com.sumanth.projects.pilotconcurrentws.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.sumanth.projects")
public class NewsConfig {
	
	@Bean
	public ClientHttpRequestFactory httpRequestFactory() {
		return new HttpComponentsClientHttpRequestFactory(httpClient());
	}
	
	@Bean
	public HttpClient httpClient() {
		PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(3000).setConnectionRequestTimeout(3000)
				.setSocketTimeout(2000).build();
		connMgr.setMaxTotal(20);
		connMgr.setDefaultMaxPerRoute(5);
		HttpClient client = HttpClientBuilder.create().setConnectionManager(connMgr).setDefaultRequestConfig(config)
				.build();
		return client;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(httpRequestFactory());
		return restTemplate;
	}

}

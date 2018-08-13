package com.sumanth.projects.pilotconcurrentws.service;

import java.util.concurrent.Executor;

import org.springframework.stereotype.Component;

@Component
public class ExecutorBean {
	
	private Executor executor;

	public ExecutorBean(Executor executor) {
		super();
		this.executor = executor;
	}

	public Executor getExecutor() {
		return executor;
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}
	
	
	
}

package com.itvedant.bakeryshops;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="game")
public class GameStoreProperties {
	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	
	
}

package com.itvedant.bakeryshops;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
@SpringBootApplication
@EnableConfigurationProperties({GameStoreProperties.class})
public class GameStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(GameStoreApplication.class, args);
	}
}

package com.svc.layer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class LayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LayerApplication.class, args);
	}

}

package com.asiczen.cache.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedisCacheMaintenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheMaintenanceApplication.class, args);
	}

}

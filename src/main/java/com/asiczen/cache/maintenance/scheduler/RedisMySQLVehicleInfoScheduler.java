package com.asiczen.cache.maintenance.scheduler;

import com.asiczen.cache.maintenance.model.VehicleInfo;
import com.asiczen.cache.maintenance.service.VehicleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RedisMySQLVehicleInfoScheduler {

	@Autowired
    VehicleInfoService vehicleInfoService;

	@Scheduled(fixedDelay = 60000)
	public void updateRedisCache() {

		log.trace("Running refresh from mysql to Redis");
        vehicleInfoService.refreshRedisWithVehicleInfoFromMysql();
		log.trace("Refresh from mysql to Redis finished");
	}
}

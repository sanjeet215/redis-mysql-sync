package com.asiczen.cache.maintenance.service;

import org.springframework.stereotype.Service;

@Service
public interface VehicleInfoService {

	public void refreshRedisWithVehicleInfoFromMysql();

}

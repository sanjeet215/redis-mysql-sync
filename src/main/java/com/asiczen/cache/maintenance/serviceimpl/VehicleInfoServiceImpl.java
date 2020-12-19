package com.asiczen.cache.maintenance.serviceimpl;

import com.asiczen.cache.maintenance.repository.RedisVehicleInfoRepository;
import com.asiczen.cache.maintenance.repository.VehicleInfoRepository;
import com.asiczen.cache.maintenance.service.VehicleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VehicleInfoServiceImpl implements VehicleInfoService {

    @Autowired
    VehicleInfoRepository vehicleInfoRepository;

    @Autowired
    RedisVehicleInfoRepository redisVehicleInfoRepository;

    @Override
    public void refreshRedisWithVehicleInfoFromMysql() {
        vehicleInfoRepository.findAll().parallelStream().filter(record -> record.getImei() != null)
                .forEach(record -> redisVehicleInfoRepository.save(record));
    }
}

package com.asiczen.cache.maintenance.repository;

import com.asiczen.cache.maintenance.model.VehicleInfo;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisVehicleInfoRepository {

    private final String KEY = "VINFO";

    private HashOperations<String, String, VehicleInfo> hashOperations;

    private RedisTemplate<String, VehicleInfo> redisTemplate;

    public RedisVehicleInfoRepository(RedisTemplate<String, VehicleInfo> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(VehicleInfo vehicleInfo) {
        hashOperations.put(KEY, vehicleInfo.getImei(), vehicleInfo);
    }
}

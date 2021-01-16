package com.asiczen.cache.maintenance.repository;

import com.asiczen.cache.maintenance.model.OrganizationView;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisOrganizationParametersRepository {

    private final String KEY = "ORGPARAMETERS";

    private HashOperations<String, String, OrganizationView> hashOperations;

    private RedisTemplate<String, OrganizationView> redisTemplate;

    public RedisOrganizationParametersRepository(RedisTemplate<String, OrganizationView> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(OrganizationView organizationView) {
        hashOperations.put(KEY, String.valueOf(organizationView.getOrgRefName()), organizationView);
    }
}


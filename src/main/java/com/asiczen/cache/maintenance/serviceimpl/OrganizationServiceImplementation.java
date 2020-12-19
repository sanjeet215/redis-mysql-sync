package com.asiczen.cache.maintenance.serviceimpl;

import com.asiczen.cache.maintenance.repository.OrganizationRepository;
import com.asiczen.cache.maintenance.repository.RedisOrganizationParametersRepository;
import com.asiczen.cache.maintenance.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrganizationServiceImplementation implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    RedisOrganizationParametersRepository redisOrganizationParametersRepository;

    @Override
    public void refreshOrganizationViewInRedisFromMySql() {
        // Step 1. Read organization related data from mysql based on input parameter.
        // Step 2. post them to redis database
        organizationRepository.findAll().parallelStream()
                .forEach(record -> redisOrganizationParametersRepository.save(record));


    }
}

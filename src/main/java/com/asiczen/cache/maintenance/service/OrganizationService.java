package com.asiczen.cache.maintenance.service;

import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {
    public void refreshOrganizationViewInRedisFromMySql();
}

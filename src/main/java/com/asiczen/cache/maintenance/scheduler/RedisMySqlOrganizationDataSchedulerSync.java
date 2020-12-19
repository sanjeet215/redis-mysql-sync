package com.asiczen.cache.maintenance.scheduler;

import com.asiczen.cache.maintenance.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisMySqlOrganizationDataSchedulerSync {

    @Autowired
    OrganizationService organizationService;

    @Scheduled(fixedDelay = 60000)
    public void refreshOrganizationInformationInRedis() {
        organizationService.refreshOrganizationViewInRedisFromMySql();
    }
}

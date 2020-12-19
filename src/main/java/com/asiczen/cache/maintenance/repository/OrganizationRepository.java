package com.asiczen.cache.maintenance.repository;

import com.asiczen.cache.maintenance.model.OrganizationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationView,Long> {

}

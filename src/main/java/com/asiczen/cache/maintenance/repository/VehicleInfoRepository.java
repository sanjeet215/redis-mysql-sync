package com.asiczen.cache.maintenance.repository;

import com.asiczen.cache.maintenance.model.VehicleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleInfoRepository extends JpaRepository<VehicleInfo,Long> {
}

package com.asiczen.cache.maintenance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "vehicleinfo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleInfo implements Serializable {

    private static final long serialVersionUID = -2670607325919116429L;

    @Id
    private long vehicleId;
    private String imei;
    private String vehicleNumber;
    private String vehicleType;
    private String driverName;
    private String driverNumber;
    private String orgRefName;

}
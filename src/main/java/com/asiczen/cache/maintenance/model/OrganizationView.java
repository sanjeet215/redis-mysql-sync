package com.asiczen.cache.maintenance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organization_view")
public class OrganizationView {

    @Id
    private long orgId;
    private String orgRefName;
    private String orgName;
    private boolean status;

    private Integer overSpeedLimit = 0;
    private Integer underSpeedLimit = 0;
    private Integer fuelLimit = 0;
    private Integer underUtilizedHours = 0;
    private Integer overUtilizedHours = 0;
    private Integer underUtilizedKms = 0;
    private Integer overUtilizedKms = 0;

}

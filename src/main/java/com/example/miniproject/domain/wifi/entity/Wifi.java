package com.example.miniproject.domain.wifi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "WIFI_INFO")
public class Wifi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mgr_no")
    private String mgrNo;
    private String borough;
    private String name;
    private String address1;
    private String address2;
    private String floor;

    @Column(name = "install_type")
    private String installType;

    @Column(name = "installation_agency")
    private String installationAgency;

    @Column(name = "service_classification")
    private String serviceClassification;

    @Column(name = "type_of_net")
    private String typeOfNet;

    @Column(name = "year_of_installation")
    private Integer yearOfInstallation;

    @Column(name = "door_division")
    private String doorDivision;

    private String environment;
    private String latitude;
    private String longitude;

    @Column(name = "work_date")
    private String workDate;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "create_by")
    private String createBy;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "update_by")
    private String updateBy;

}

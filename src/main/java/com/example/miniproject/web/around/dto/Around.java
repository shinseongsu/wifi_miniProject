package com.example.miniproject.web.around.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Around {

    private Double distance;
    private String mgrNo;
    private String borough;
    private String name;
    private String address1;
    private String address2;
    private String floor;
    private String installType;
    private String installationAgency;
    private String serviceClassification;
    private String typeOfNet;
    private Integer yearOfInstallation;
    private String doorDivision;
    private String environment;
    private String latitude;
    private String longitude;
    private String workDate;


}

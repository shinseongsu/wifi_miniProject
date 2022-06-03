package com.example.miniproject.web.wifi.dto;

import com.example.miniproject.domain.wifi.entity.Wifi;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class WifiRow {

    @SerializedName(value = "X_SWIFI_MGR_NO")
    private String xSwifiMgrNo;
    @SerializedName(value = "X_SWIFI_WRDOFC")
    private String xSwifiWrdofc;
    @SerializedName(value = "X_SWIFI_MAIN_NM")
    private String xSwifiMainNm;
    @SerializedName(value = "X_SWIFI_ADRES1")
    private String xSwifiAdres1;
    @SerializedName(value = "X_SWIFI_ADRES2")
    private String xSwifiAdres2;
    @SerializedName(value = "X_SWIFI_INSTL_FLOOR")
    private String xSwifiInstlFloor;
    @SerializedName(value = "X_SWIFI_INSTL_TY")
    private String xSwifiInstlTy;
    @SerializedName(value = "X_SWIFI_INSTL_MBY")
    private String xSwifiInstlMby;
    @SerializedName(value = "X_SWIFI_SVC_SE")
    private String xSwifiSvcSe;
    @SerializedName(value = "X_SWIFI_CMCWR")
    private String xSwifiCmcwr;
    @SerializedName(value = "X_SWIFI_CNSTC_YEAR")
    private Integer xSwifiCnstcYear;
    @SerializedName(value = "X_SWIFI_INOUT_DOOR")
    private String xSwifiInoutDoor;
    @SerializedName(value = "X_SWIFI_REMARS3")
    private String xSwifiRemars3;
    @SerializedName(value = "LAT")
    private String lat;
    @SerializedName(value = "LNT")
    private String lnt;
    @SerializedName(value = "WORK_DTTM")
    private String workDttm;

    public Wifi toEntity() {
        return Wifi.builder()
                .mgrNo(xSwifiMgrNo)
                .borough(xSwifiWrdofc)
                .name(xSwifiMainNm)
                .address1(xSwifiAdres1)
                .address2(xSwifiAdres2)
                .floor(xSwifiInstlFloor)
                .installType(xSwifiInstlTy)
                .installationAgency(xSwifiInstlMby)
                .serviceClassification(xSwifiSvcSe)
                .typeOfNet(xSwifiCmcwr)
                .yearOfInstallation(xSwifiCnstcYear)
                .doorDivision(xSwifiInoutDoor)
                .environment(xSwifiRemars3)
                .latitude(lat)
                .longitude(lnt)
                .workDate(workDttm)
                .build();
    }

}

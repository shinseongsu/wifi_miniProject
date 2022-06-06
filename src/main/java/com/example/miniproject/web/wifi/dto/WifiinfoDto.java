package com.example.miniproject.web.wifi.dto;

import com.example.miniproject.constant.ApiStatus;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WifiinfoDto {

    @SerializedName(value = "TbPublicWifiInfo")
    private TbPublicWifiInfoDto tbPublicWifiInfo;

    public String status() {
        return this.tbPublicWifiInfo.getResult().getCode();
    }

    public WifiRow[] rows() {
        return this.tbPublicWifiInfo.getRow();
    }

    public boolean isSuccess() {
        return ApiStatus.SUCCESS.getCode().equals(this.status());
    }

    public boolean isFinish(Integer nextPage) {
        return getTbPublicWifiInfo().getListTotalCount() <= nextPage;
    }

}

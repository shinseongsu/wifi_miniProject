package com.example.miniproject.web.wifi.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TbPublicWifiInfoDto {

    private Integer listTotalCount;

    @SerializedName(value = "RESULT")
    private ResultCode result;
    private WifiRow[] row;

}

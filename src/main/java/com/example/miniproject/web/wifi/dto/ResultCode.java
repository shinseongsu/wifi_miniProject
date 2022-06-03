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
public class ResultCode {

    @SerializedName(value = "CODE")
    private String code;
    @SerializedName(value = "MESSAGE")
    private String message;
}

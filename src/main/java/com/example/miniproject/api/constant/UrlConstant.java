package com.example.miniproject.api.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum UrlConstant {

    URL("http://openapi.seoul.go.kr:8088"),
    KEY("756a66554f6c65783638724a427564"),

    TYPE("json"),
    DIVISION("TbPublicWifiInfo");

    private String value;


}

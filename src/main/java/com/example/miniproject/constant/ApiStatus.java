package com.example.miniproject.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiStatus {

    SUCCESS("INFO-000");

    private String code;

}

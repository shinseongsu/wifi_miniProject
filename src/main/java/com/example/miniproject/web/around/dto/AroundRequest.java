package com.example.miniproject.web.around.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AroundRequest {
    private String latitude;
    private String longitude;

}

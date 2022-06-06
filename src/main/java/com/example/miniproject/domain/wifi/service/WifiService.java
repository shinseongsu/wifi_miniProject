package com.example.miniproject.domain.wifi.service;

import com.example.miniproject.domain.wifi.repository.WifiRepository;
import com.example.miniproject.web.around.dto.Around;
import com.example.miniproject.web.around.dto.AroundRequest;

import java.util.List;

public class WifiService {

    public List<Around> selectAround(AroundRequest aroundRequest) {
        WifiRepository wifiRepository = new WifiRepository();
        return wifiRepository.findTop20OrderByDistance(aroundRequest);
    }

}

package com.example.miniproject.web.around.service;

import com.example.miniproject.domain.history.service.HistoryService;
import com.example.miniproject.domain.wifi.service.WifiService;
import com.example.miniproject.web.around.dto.Around;
import com.example.miniproject.web.around.dto.AroundRequest;

import java.util.List;

public class AroundService {

    public List<Around> selectAround(AroundRequest aroundRequest) {
        WifiService wifiService = new WifiService();
        HistoryService historyService = new HistoryService();

        historyService.HisotryLogSave(aroundRequest);
        return wifiService.selectAround(aroundRequest);
    }

}

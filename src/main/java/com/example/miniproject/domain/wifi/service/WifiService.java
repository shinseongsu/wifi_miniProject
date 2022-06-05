package com.example.miniproject.domain.wifi.service;

import com.example.miniproject.api.OkHttpService;
import com.example.miniproject.api.OkHttpServiceFactory;
import com.example.miniproject.api.dto.ApiRequestDto;
import com.example.miniproject.config.HibernateManager;
import com.example.miniproject.constant.ApiStatus;
import com.example.miniproject.domain.wifi.entity.Wifi;
import com.example.miniproject.domain.wifi.repository.WifiRepository;
import com.example.miniproject.web.around.dto.Around;
import com.example.miniproject.web.around.dto.AroundRequest;
import com.example.miniproject.web.wifi.dto.WifiRow;
import com.example.miniproject.web.wifi.dto.WifiinfoDto;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Response;

import java.util.List;

public class WifiService {

    public Integer wifiInfoSave() throws Exception {
        WifiRepository wifiRepository = new WifiRepository();
        OkHttpService okHttpService = OkHttpServiceFactory.getService("wifi");
        ApiRequestDto apiRequestDto = new ApiRequestDto();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        Integer result = 0;
        HibernateManager.txBegin();

        wifiRepository.init();

        while(true) {
            Response response = okHttpService.send(apiRequestDto);

            if (!response.isSuccessful()) {
                HibernateManager.txRollback();
                break;
            }

            WifiinfoDto wifiinfoDto = gson.fromJson(response.body().string(), WifiinfoDto.class);

            if (ApiStatus.SUCCESS.getCode().equals(wifiinfoDto.status())) {
                for (WifiRow wifiRow : wifiinfoDto.rows()) {
                    wifiRepository.save(wifiRow.toEntity());
                }
            }

            if( wifiinfoDto.getTbPublicWifiInfo().getListTotalCount() <= apiRequestDto.getNextPage()) {
                result = wifiinfoDto.getTbPublicWifiInfo().getListTotalCount();
                break;
            }
            apiRequestDto.nextPage();
        }

        HibernateManager.txCommit();
        return result;
    }

    public List<Around> selectAround(AroundRequest aroundRequest) {
        WifiRepository wifiRepository = new WifiRepository();
        return wifiRepository.findTop20OrderByDistance(aroundRequest);
    }

}

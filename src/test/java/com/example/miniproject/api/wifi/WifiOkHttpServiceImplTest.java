package com.example.miniproject.api.wifi;

import com.example.miniproject.api.OkHttpService;
import com.example.miniproject.api.dto.ApiRequestDto;
import com.example.miniproject.constant.ApiStatus;
import com.example.miniproject.web.wifi.dto.WifiinfoDto;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class WifiOkHttpServiceImplTest {

    @Test
    public void 공공_데이터_테스트() throws Exception {
        OkHttpService okHttpService = new WifiOkHttpServiceImpl();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        ApiRequestDto request = new ApiRequestDto();

        Response response = okHttpService.send(request);

        WifiinfoDto wifiinfoDto = gson.fromJson(response.body().string(), WifiinfoDto.class);

        String code = wifiinfoDto.getTbPublicWifiInfo().getResult().getCode();
        int count = wifiinfoDto.getTbPublicWifiInfo().getListTotalCount();

        Assertions.assertAll(
                () -> assertEquals(code, ApiStatus.SUCCESS.getCode()),
                () -> assertEquals(count, 14497)
        );

    }

}

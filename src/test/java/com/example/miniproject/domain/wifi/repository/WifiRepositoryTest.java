package com.example.miniproject.domain.wifi.repository;

import com.example.miniproject.web.around.dto.Around;
import com.example.miniproject.web.around.dto.AroundRequest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WifiRepositoryTest {

    @Test
    public void 조회_테스트() {
        WifiRepository wifiRepository = new WifiRepository();

        AroundRequest aroundRequest = AroundRequest.builder()
                .latitude("37.2152153")
                .longitude("126.9750155")
                .build();

        List<Around> arounds = wifiRepository.findTop20OrderByDistance(aroundRequest);

        arounds.forEach( around -> assertTrue( around != null ));
    }

}

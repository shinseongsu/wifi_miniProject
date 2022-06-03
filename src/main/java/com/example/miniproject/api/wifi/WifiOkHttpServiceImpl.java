package com.example.miniproject.api.wifi;

import com.example.miniproject.api.OkHttpService;
import com.example.miniproject.api.dto.ApiRequestDto;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WifiOkHttpServiceImpl implements OkHttpService {

    @Override
    public Response send(ApiRequestDto apiRequestDto) throws Exception {
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl.Builder url = HttpUrl.parse("http://openapi.seoul.go.kr:8088")
                .newBuilder();
        url.addPathSegment("756a66554f6c65783638724a427564")
                .addPathSegment("json")
                .addPathSegment("TbPublicWifiInfo")
                .addPathSegment( apiRequestDto.currentPageToString() )
                .addPathSegment( apiRequestDto.nextPageToString() );

        Request okRequest = new Request.Builder()
                .url(url.toString())
                .get()
                .build();

        return okHttpClient.newCall(okRequest).execute();
    }

}

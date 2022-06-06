package com.example.miniproject.api.wifi;

import com.example.miniproject.api.OkHttpService;
import com.example.miniproject.api.constant.UrlConstant;
import com.example.miniproject.api.dto.ApiRequestDto;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WifiOkHttpServiceImpl implements OkHttpService {

    @Override
    public Response send(ApiRequestDto apiRequestDto) throws Exception {
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl.Builder url = HttpUrl.parse(UrlConstant.URL.getValue())
                .newBuilder();
        url.addPathSegment(UrlConstant.KEY.getValue())
                .addPathSegment(UrlConstant.TYPE.getValue())
                .addPathSegment(UrlConstant.DIVISION.getValue())
                .addPathSegment( apiRequestDto.currentPageToString() )
                .addPathSegment( apiRequestDto.nextPageToString() );

        Request okRequest = new Request.Builder()
                .url(url.toString())
                .get()
                .build();

        return okHttpClient.newCall(okRequest).execute();
    }

}

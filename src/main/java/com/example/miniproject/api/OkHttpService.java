package com.example.miniproject.api;

import com.example.miniproject.api.dto.ApiRequestDto;
import okhttp3.Response;

public interface OkHttpService {

    public Response send(ApiRequestDto apiRequestDto) throws Exception;

}

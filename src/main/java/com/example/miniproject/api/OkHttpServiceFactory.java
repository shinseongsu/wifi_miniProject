package com.example.miniproject.api;

import com.example.miniproject.api.wifi.WifiOkHttpServiceImpl;

public class OkHttpServiceFactory {

    public static OkHttpService getService(String type) {
        switch (type) {
            case "wifi":
                return new WifiOkHttpServiceImpl();
            default:
                return null;
        }
    }

}

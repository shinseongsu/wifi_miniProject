package com.example.miniproject.web.wifi.controller;

import com.example.miniproject.config.HibernateManager;
import com.example.miniproject.constant.ApiStatus;
import com.example.miniproject.domain.wifi.entity.Wifi;
import com.example.miniproject.domain.wifi.service.WifiService;
import com.example.miniproject.web.wifi.dto.WifiRow;
import com.example.miniproject.web.wifi.dto.WifiinfoDto;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WifiApiServlet", value = "/wifiRequeest")
public class WifiApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WifiService wifiService = new WifiService();

        try {
            request.setAttribute("count", wifiService.wifiInfoSave());
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/wifi/wifiResult.jsp");
        dispatcher.forward(request, response);
    }
}

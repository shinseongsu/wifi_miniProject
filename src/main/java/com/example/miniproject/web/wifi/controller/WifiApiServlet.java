package com.example.miniproject.web.wifi.controller;

import com.example.miniproject.web.wifi.service.WifiSearchService;

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
        WifiSearchService wifiService = new WifiSearchService();

        try {
            request.setAttribute("count", wifiService.wifiInfoSave());
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/wifi/wifiResult.jsp");
        dispatcher.forward(request, response);
    }
}

package com.example.miniproject.web.around.controller;

import com.example.miniproject.web.around.dto.AroundRequest;
import com.example.miniproject.web.around.service.AroundService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "AroundServlet", value = "/around")
public class AroundServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            jb.append(line);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        AroundRequest aroundRequest = objectMapper.readValue(jb.toString(), AroundRequest.class);


        AroundService aroundService = new AroundService();
        String json = new Gson().toJson(aroundService.selectAround(aroundRequest));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}

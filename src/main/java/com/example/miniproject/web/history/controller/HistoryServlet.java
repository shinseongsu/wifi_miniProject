package com.example.miniproject.web.history.controller;

import com.example.miniproject.domain.history.service.HistoryService;
import com.example.miniproject.web.around.dto.AroundRequest;
import com.example.miniproject.web.history.dto.DeleteHistoryRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "HistoryServlet", value = "/history")
public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HistoryService historyService = new HistoryService();
        request.setAttribute("historyList", historyService.selectHistory());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/history/history.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            jb.append(line);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        DeleteHistoryRequest deleteHistoryRequest = objectMapper.readValue(jb.toString(), DeleteHistoryRequest.class);


        HistoryService historyService = new HistoryService();

        String json = "";
        try {
            historyService.deleteHistory(deleteHistoryRequest.getId());

            HashMap map = new HashMap();
            map.put("code", "0000");
            map.put("message", "성공하였습니다.");

            json = new Gson().toJson(map);
        } catch (Exception e) {
            e.printStackTrace();
            HashMap map = new HashMap();
            map.put("code", "9999");
            map.put("message", "에러가 발생하였습니다.");

            json = new Gson().toJson(map);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}

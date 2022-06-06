package com.example.miniproject.domain.history.service;

import com.example.miniproject.config.HibernateManager;
import com.example.miniproject.domain.history.entity.History;
import com.example.miniproject.domain.history.repository.HistoryRepository;
import com.example.miniproject.web.around.dto.AroundRequest;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

public class HistoryService {

    public void HisotryLogSave(AroundRequest aroundRequest) {
        HistoryRepository historyRepository = new HistoryRepository();
        History history = History.builder()
                .latitude(aroundRequest.getLatitude())
                .longitude(aroundRequest.getLongitude())
                .searchDate(LocalDateTime.now())
                .createDate(LocalDateTime.now())
                .createBy("SYSTEM")
                .updateDate(LocalDateTime.now())
                .updateBy("SYSTEM")
                .build();

        historyRepository.save(history);
    }

    public List<History> selectHistory() {
        HistoryRepository historyRepository = new HistoryRepository();
        return historyRepository.findAll();
    }

    public void deleteHistory(Long id) throws Exception {
        HistoryRepository historyRepository = new HistoryRepository();
        HibernateManager.txBegin();

        historyRepository.deleteById(id);

        HibernateManager.txCommit();
    }

}

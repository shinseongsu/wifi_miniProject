package com.example.miniproject.domain.history.repository;

import com.example.miniproject.domain.history.entity.History;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HistoryRepositoryTest {

    @Test
    public void 히스토리_전체_조회() {
        HistoryRepository historyRepository = new HistoryRepository();

        List<History> historys = historyRepository.findAll();

        historys.forEach( history -> { assertTrue( history.getLatitude() != null ); } );
    }

}

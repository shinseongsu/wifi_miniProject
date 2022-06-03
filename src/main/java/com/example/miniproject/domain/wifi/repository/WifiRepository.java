package com.example.miniproject.domain.wifi.repository;

import com.example.miniproject.config.HibernateManager;
import com.example.miniproject.domain.wifi.entity.Wifi;

import javax.persistence.EntityManager;

public class WifiRepository {

    public void save(Wifi wifi) {
        EntityManager entityManager = HibernateManager.getInstance();
        entityManager.persist(wifi);
    }

}

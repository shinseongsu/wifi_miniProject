package com.example.miniproject.domain.wifi.repository;

import com.example.miniproject.config.HibernateManager;
import com.example.miniproject.domain.wifi.entity.Wifi;
import com.example.miniproject.web.around.dto.Around;
import com.example.miniproject.web.around.dto.AroundRequest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class WifiRepository {

    public void save(Wifi wifi) {
        EntityManager entityManager = HibernateManager.getInstance();
        entityManager.persist(wifi);
    }

    public List findByAround(AroundRequest aroundRequest) {
        EntityManager entityManager = HibernateManager.getInstance();

        String query = "select w, " +
                       "(6371*acos(cos(radians(:latitude))*cos(radians(w.latitude))*cos(radians(w.longitude) - radians(:latitude))+sin(radians(:longitude))*sin(radians(w.latitude)))) AS distance " +
                       " from Wifi w " +
                       "order by distance desc";

        Query distanceQuery = entityManager.createQuery(query);
        distanceQuery.setParameter("latitude", aroundRequest.getLatitude());
        distanceQuery.setParameter("longitude", aroundRequest.getLongitude());

        distanceQuery.setFirstResult(0);
        distanceQuery.setMaxResults(20);
        return distanceQuery.getResultList();
    }

}

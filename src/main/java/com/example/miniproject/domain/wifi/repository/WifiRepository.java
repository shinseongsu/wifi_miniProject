package com.example.miniproject.domain.wifi.repository;

import com.example.miniproject.config.HibernateManager;
import com.example.miniproject.domain.wifi.entity.Wifi;
import com.example.miniproject.web.around.dto.Around;
import com.example.miniproject.web.around.dto.AroundRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hibernate.annotations.QueryHints;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class WifiRepository {

    public void init() {
        EntityManager entityManager = HibernateManager.getInstance();

        String sql = "delete from Wifi";
        entityManager.createQuery(sql).executeUpdate();
    }

    public void save(Wifi wifi) {
        EntityManager entityManager = HibernateManager.getInstance();
        entityManager.persist(wifi);
    }

    public List<Around> findTop20OrderByDistance(AroundRequest aroundRequest) {
        EntityManager entityManager = HibernateManager.getInstance();

        String query = "select new com.example.miniproject.web.around.dto.Around( ROUND( (6371.0 * acos( cos( radians(:latitude) ) * cos( radians( w.latitude )) * cos( radians( w.longitude ) - radians(:longitude))  + sin( radians(:latitude)) * sin( radians(w.latitude)))),2), w.mgrNo, w.borough, w.name, w.address1, w.address2, w.floor, w.installType, w.installationAgency, w.serviceClassification, w.typeOfNet, w.yearOfInstallation, w.doorDivision, w.environment, w.latitude, w.longitude, w.workDate)  " +
                       "from Wifi w " +
                       "order by (6371.0 * acos( cos( radians(:latitude) ) * cos( radians( w.latitude )) * cos( radians( w.longitude ) - radians(:longitude))  + sin( radians(:latitude)) * sin( radians(w.latitude)))) ";

        return entityManager.createQuery(query, Around.class)
                        .setParameter("latitude", aroundRequest.getLatitude())
                        .setParameter("longitude", aroundRequest.getLongitude())
                        .setFirstResult(0)
                        .setMaxResults(20)
                        .setHint(QueryHints.READ_ONLY, true)
                        .getResultList();
    }

}

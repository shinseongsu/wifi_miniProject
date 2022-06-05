package com.example.miniproject.domain.history.repository;

import com.example.miniproject.config.HibernateManager;
import com.example.miniproject.domain.history.entity.History;
import com.example.miniproject.web.around.dto.Around;
import org.hibernate.annotations.QueryHints;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class HistoryRepository {

    public void save(History history) {
        EntityManager entityManager = HibernateManager.getInstance();
        HibernateManager.txBegin();
        entityManager.persist(history);
        HibernateManager.txCommit();
    }

    public List<History> findAll() {
        EntityManager entityManager = HibernateManager.getInstance();
        return entityManager.createQuery("from History", History.class)
                .setHint(QueryHints.READ_ONLY, true)
                .getResultList();
    }

    public void deleteById(Long id) throws Exception {
        EntityManager entityManager = HibernateManager.getInstance();
        entityManager.createQuery("delete from History where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

}

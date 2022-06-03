package com.example.miniproject.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateManager {

    public static EntityManager entityManager;

    public static EntityManager getInstance() {
        if(entityManager == null) {
            try {
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
                entityManager = entityManagerFactory.createEntityManager();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entityManager;
    }

    public static void txBegin() {
        getInstance().getTransaction().begin();;
    }

    public static void txCommit() {
        getInstance().getTransaction().commit();
    }

    public static void txRollback() {
        getInstance().getTransaction().rollback();
    }

}

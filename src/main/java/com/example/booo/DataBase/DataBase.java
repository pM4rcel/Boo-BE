package com.example.booo.DataBase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class DataBase {
    private static final EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("default");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();


    public static EntityManager getInstance() {
        return entityManager;
    }
}

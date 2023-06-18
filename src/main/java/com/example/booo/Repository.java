package com.example.booo;

import com.example.booo.DataBase.DataBase;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.List;

public interface Repository<T extends Serializable, ID> {
    T findByID(ID id);
    List<T> findAll();
    default <S extends T> S save(S entity){
        DataBase.getInstance().getTransaction().begin();
        DataBase.getInstance().persist(entity);
        DataBase.getInstance().getTransaction().commit();
        return entity;
    }
    void deleteByID(ID id);
}

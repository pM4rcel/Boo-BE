package com.example.booo.Author;

import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

import java.util.List;

public class AuthorRepository implements Repository<AuthorEntity, Long> {

    @Override
    public AuthorEntity findByID(Long aLong) {
        return DataBase.getInstance().find(AuthorEntity.class, aLong);
    }

    @Override
    public List<AuthorEntity> findAll() {
        var query = DataBase.getInstance().createNamedQuery("author.findAll", AuthorEntity.class);
        return query.getResultList();
    }
    @Override
    public void deleteByID(Long aLong){
            DataBase.getInstance().getTransaction().begin();
            AuthorEntity a = findByID(aLong);
            DataBase.getInstance().remove(a);
            DataBase.getInstance().getTransaction().commit();
    }
}

package com.example.booo.Genre;

import com.example.booo.BookGenres.BookGenresEntity;
import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

import javax.xml.crypto.Data;
import java.util.List;

public abstract class GenreRepository implements Repository<GenreEntity, Long> {

    @Override
    public GenreEntity findByID(Long aLong) {
        var query = DataBase.getInstance().createNamedQuery("genres.findById", GenreEntity.class);
        query.setParameter(1, aLong);
        return query.getSingleResult();
    }
    @Override
    public List<GenreEntity> findAll() {
        return DataBase.getInstance().createNamedQuery("genres.findAll", GenreEntity.class)
                .getResultList();
    }
    @Override
    public void deleteByID(Long aLong) {
        DataBase.getInstance().getTransaction().begin();
        GenreEntity g = findByID(aLong);
        DataBase.getInstance().remove(g);
        DataBase.getInstance().getTransaction().commit();
    }
}

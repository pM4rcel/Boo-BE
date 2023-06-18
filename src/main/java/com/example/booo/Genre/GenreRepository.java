package com.example.booo.Genre;

import com.example.booo.BookGenres.BookGenresEntity;
import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

public abstract class GenreRepository implements Repository<GenreEntity, Long> {
    @Override
    public void deleteByID(Long aLong) {
        DataBase.getInstance().getTransaction().begin();
        GenreEntity g = findByID(aLong);
        DataBase.getInstance().remove(g);
        DataBase.getInstance().getTransaction().commit();
    }
}

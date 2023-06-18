package com.example.booo.BookGenres;

import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

public abstract class BookGenresRepository implements Repository<BookGenresEntity, Long> {

    @Override
    public void deleteByID(Long aLong) {
        DataBase.getInstance().getTransaction().begin();
        BookGenresEntity b = findByID(aLong);
        DataBase.getInstance().remove(b);
        DataBase.getInstance().getTransaction().commit();
    }
}

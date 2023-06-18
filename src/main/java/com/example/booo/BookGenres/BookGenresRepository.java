package com.example.booo.BookGenres;

import com.example.booo.DataBase.DataBase;
import com.example.booo.Group.GroupEntity;
import com.example.booo.Repository;

public abstract class BookGenresRepository implements Repository<BookGenresEntity, Long> {

    public BookGenresEntity findByGenreId(Long aLong) {
        return DataBase.getInstance().createNamedQuery("book_genre.findByGenreId", BookGenresEntity.class)
                .setParameter(1, aLong)
                .getSingleResult();
    }
    public BookGenresEntity findByBookId(Long aLong) {
        return DataBase.getInstance().createNamedQuery("book_genre.findByBookId", BookGenresEntity.class)
                .setParameter(1, aLong)
                .getSingleResult();
    }
    @Override
    public void deleteByID(Long aLong) {
        DataBase.getInstance().getTransaction().begin();
        BookGenresEntity b = findByID(aLong);
        DataBase.getInstance().remove(b);
        DataBase.getInstance().getTransaction().commit();
    }
}

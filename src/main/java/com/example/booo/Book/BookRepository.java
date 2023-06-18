package com.example.booo.Book;

import com.example.booo.Author.AuthorEntity;
import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

import java.util.List;

public class BookRepository implements Repository<BookEntity, Long> {

    @Override
    public BookEntity findByID(Long aLong) {
        return DataBase.getInstance().find(BookEntity.class, aLong);
    }

    @Override
    public List<BookEntity> findAll() {
        var query = DataBase.getInstance().createNamedQuery("book.findAll", BookEntity.class);
        return query.getResultList();

    }
    @Override
    public void deleteByID(Long aLong) {
        DataBase.getInstance().getTransaction().begin();
        BookEntity b = findByID(aLong);
        DataBase.getInstance().remove(b);
        DataBase.getInstance().getTransaction().commit();
    }
}

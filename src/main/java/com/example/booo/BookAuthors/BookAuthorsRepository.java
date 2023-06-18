package com.example.booo.BookAuthors;

import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

import java.util.List;

public abstract class BookAuthorsRepository implements Repository<BookAuthorsEntity, Long> {
    public List<BookAuthorsEntity> findByAuthorId(Long aLong){
        return DataBase.getInstance().createNamedQuery("book_authors.findByAuthorID", BookAuthorsEntity.class)
                .setParameter(1, aLong)
                .getResultList();
    }
    public List<BookAuthorsEntity> findByBookId(Long aLong){
        return DataBase.getInstance().createNamedQuery("book_authors.findByBookId", BookAuthorsEntity.class)
                .setParameter(1, aLong)
                .getResultList();
    }
}

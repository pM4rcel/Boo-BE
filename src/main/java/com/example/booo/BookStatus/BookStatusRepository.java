package com.example.booo.BookStatus;

import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;


import java.util.List;

public abstract class BookStatusRepository implements Repository<BookStatusEntity, Long> {
    public BookStatusEntity findByBookId(Long aLong){
        var query = DataBase.getInstance().createNamedQuery("book_status.findByBookId", BookStatusEntity.class);
        query.setParameter(1, aLong);
        return query.getSingleResult();
    }
    public BookStatusEntity findByUserId(Long aLong){
        var query = DataBase.getInstance().createNamedQuery("book_status.findByUserId", BookStatusEntity.class);
        query.setParameter(1, aLong);
        return query.getSingleResult();
    }
    public List<BookStatusEntity> findByUserIdAndStatus(String status, Long aLong){
        var query = DataBase.getInstance().createNamedQuery("book_status.findByUserIdAndStatus", BookStatusEntity.class);
        query.setParameter(1, aLong).setParameter(2, status);
        return query.getResultList();
    }
}

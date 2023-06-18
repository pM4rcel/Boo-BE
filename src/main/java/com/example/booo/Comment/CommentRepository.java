package com.example.booo.Comment;

import com.example.booo.BookGenres.BookGenresEntity;
import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

public abstract class CommentRepository implements Repository<CommentEntity, Long> {
    @Override
    public void deleteByID(Long aLong) {
        DataBase.getInstance().getTransaction().begin();
        CommentEntity c = findByID(aLong);
        DataBase.getInstance().remove(c);
        DataBase.getInstance().getTransaction().commit();
    }
}

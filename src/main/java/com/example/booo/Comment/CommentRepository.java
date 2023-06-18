package com.example.booo.Comment;

import com.example.booo.BookGenres.BookGenresEntity;
import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

import java.util.List;

public abstract class CommentRepository implements Repository<CommentEntity, Long> {
    @Override
    public void deleteByID(Long aLong) {
        DataBase.getInstance().getTransaction().begin();
        CommentEntity c = findByID(aLong);
        DataBase.getInstance().remove(c);
        DataBase.getInstance().getTransaction().commit();
    }

    @Override
    public CommentEntity findByID(Long aLong) {
        return DataBase.getInstance().createNamedQuery("comment.findById", CommentEntity.class)
                .setParameter(1, aLong)
                .getSingleResult();
    }

    @Override
    public List<CommentEntity> findAll() {
        return DataBase.getInstance().createNamedQuery("comment.findAll", CommentEntity.class)
                .getResultList();
    }
}

package com.example.booo.Review;

import com.example.booo.Author.AuthorEntity;
import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

import java.util.List;

public class ReviewRepository implements Repository<ReviewEntity, Long> {
    @Override
    public ReviewEntity findByID(Long aLong) {
        return DataBase.getInstance().createNamedQuery("reviews.findById", ReviewEntity.class)
                .setParameter(1, aLong)
                .getSingleResult();
    }

    @Override
    public List<ReviewEntity> findAll() {
        return DataBase.getInstance().createNamedQuery("reviews.findAll", ReviewEntity.class)
                .getResultList();
    }

    @Override
    public void deleteByID(Long aLong) {
        DataBase.getInstance().getTransaction().begin();
        ReviewEntity r = findByID(aLong);
        DataBase.getInstance().remove(r);
        DataBase.getInstance().getTransaction().commit();
    }
}

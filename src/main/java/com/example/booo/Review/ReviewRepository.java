package com.example.booo.Review;

import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

public abstract class ReviewRepository implements Repository<ReviewEntity, Long> {
    @Override
    public void deleteByID(Long aLong) {
        DataBase.getInstance().getTransaction().begin();
        ReviewEntity r = findByID(aLong);
        DataBase.getInstance().remove(r);
        DataBase.getInstance().getTransaction().commit();
    }
}

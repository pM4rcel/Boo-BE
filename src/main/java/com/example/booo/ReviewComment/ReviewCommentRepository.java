package com.example.booo.ReviewComment;

import com.example.booo.Book.BookEntity;
import com.example.booo.BookGenres.BookGenresEntity;
import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

import java.util.List;

public abstract class ReviewCommentRepository implements Repository<ReviewCommentEntity, Long> {
    public ReviewCommentEntity findByUserId(Long aLong) {
        return DataBase.getInstance().createNamedQuery("reviewComments.findByUserId", ReviewCommentEntity.class)
                .setParameter(1, aLong)
                .getSingleResult();
    }
    public ReviewCommentEntity findByReviewId(Long aLong) {
        return DataBase.getInstance().createNamedQuery("reviewComments.findByReviewId", ReviewCommentEntity.class)
                .setParameter(1, aLong)
                .getSingleResult();
    }
    @Override
    public List<ReviewCommentEntity> findAll() {
        var query = DataBase.getInstance().createNamedQuery("reviewComments.findAll", ReviewCommentEntity.class);
        return query.getResultList();
    }

    public ReviewCommentEntity findByIDS(ReviewCommentEntityPK r) {
        return DataBase.getInstance().find(ReviewCommentEntity.class, r);
    }

    public void deleteByIdS(ReviewCommentEntityPK r) {
        DataBase.getInstance().getTransaction().begin();
        ReviewCommentEntity r1 = findByIDS(r);
        DataBase.getInstance().remove(r1);
        DataBase.getInstance().getTransaction().commit();

    }
}

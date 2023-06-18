package com.example.booo.ReviewComment;

import com.example.booo.Comment.CommentEntity;
import com.example.booo.Review.ReviewEntity;
import com.example.booo.User.UserEntity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "review_comment", schema = "public", catalog = "BooDatabase")
@IdClass(ReviewCommentEntityPK.class)
@NamedQuery(name = "reviewComments.findByUserId", query = "select a from ReviewCommentEntity a where a.userId = ?1 ")
@NamedQuery(name = "reviewComments.findByReviewId", query = "select a from ReviewCommentEntity a where a.reviewId = ?1 ")
@NamedQuery(name = "reviewComments.findAll", query = "select a from ReviewCommentEntity a")
@NamedQuery(name = "reviewComments.findByIDs", query = "select a from ReviewCommentEntity a where a.userId =?1 and a.reviewId = ?2 and a.commentId = ?3")
public class ReviewCommentEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id", nullable = false)
    private Long reviewId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "comment_id", nullable = false)
    private Long commentId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity usersByUserId;
    @ManyToOne
    @JoinColumn(name = "review_id", referencedColumnName = "id", nullable = false)
    private ReviewEntity reviewByReviewId;
    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id", nullable = false)
    private CommentEntity commentByCommentId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewCommentEntity that = (ReviewCommentEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (reviewId != null ? !reviewId.equals(that.reviewId) : that.reviewId != null) return false;
        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (reviewId != null ? reviewId.hashCode() : 0);
        result = 31 * result + (commentId != null ? commentId.hashCode() : 0);
        return result;
    }

    public UserEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UserEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    public ReviewEntity getReviewByReviewId() {
        return reviewByReviewId;
    }

    public void setReviewByReviewId(ReviewEntity reviewByReviewId) {
        this.reviewByReviewId = reviewByReviewId;
    }

    public CommentEntity getCommentByCommentId() {
        return commentByCommentId;
    }

    public void setCommentByCommentId(CommentEntity commentByCommentId) {
        this.commentByCommentId = commentByCommentId;
    }
}

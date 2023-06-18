package com.example.booo.Review;

import com.example.booo.Book.BookEntity;
import com.example.booo.ReviewComment.ReviewCommentEntity;
import com.example.booo.User.UserEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "review", schema = "public", catalog = "BooDatabase")
@NamedQuery(name = "reviews.findById", query = "select a from ReviewEntity a where a.id = ?1 ")
@NamedQuery(name = "reviews.findAll", query = "select a from ReviewEntity a")
public class ReviewEntity implements Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "rating", nullable = true)
    private Integer rating;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "createdat", nullable = true)
    private Timestamp createdat;
    @Basic
    @Column(name = "user_id", nullable = true)
    private Long userId;
    @Basic
    @Column(name = "book_id", nullable = true)
    private Long bookId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity usersByUserId;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private BookEntity bookByBookId;
    @OneToMany(mappedBy = "reviewByReviewId")
    private Collection<ReviewCommentEntity> reviewCommentsById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Timestamp createdat) {
        this.createdat = createdat;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewEntity that = (ReviewEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createdat != null ? !createdat.equals(that.createdat) : that.createdat != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (bookId != null ? !bookId.equals(that.bookId) : that.bookId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdat != null ? createdat.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (bookId != null ? bookId.hashCode() : 0);
        return result;
    }

    public UserEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UserEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    public Collection<ReviewCommentEntity> getReviewCommentsById() {
        return reviewCommentsById;
    }

    public void setReviewCommentsById(Collection<ReviewCommentEntity> reviewCommentsById) {
        this.reviewCommentsById = reviewCommentsById;
    }
}

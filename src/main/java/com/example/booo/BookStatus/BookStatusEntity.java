package com.example.booo.BookStatus;

import com.example.booo.Book.BookEntity;
import com.example.booo.User.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "book_status", schema = "public", catalog = "BooDatabase")
@IdClass(BookStatusEntityPK.class)
@NamedQueries({
        @NamedQuery(name = "book_status.findByBookId",
        query = "select b from BookStatusEntity b where b.bookId = ?1"),
        @NamedQuery(name = "book_status.findByUserId",
        query = "select b from BookStatusEntity b where b.userId = ?1 "),
        @NamedQuery(name = "book_status.findByUserIdAndStatus",
        query = "select e from BookStatusEntity e where e.userId = ?1 and e.status = ?2")
})
public class BookStatusEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "book_id", nullable = false)
    private Long bookId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Basic
    @Column(name = "status", nullable = false, length = -1)
    private String status;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private BookEntity bookByBookId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity usersByUserId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookStatusEntity that = (BookStatusEntity) o;

        if (bookId != null ? !bookId.equals(that.bookId) : that.bookId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId != null ? bookId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    public UserEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UserEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}

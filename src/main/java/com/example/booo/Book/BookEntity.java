package com.example.booo.Book;

import com.example.booo.BookAuthors.BookAuthorsEntity;
import com.example.booo.BookGenres.BookGenresEntity;
import com.example.booo.BookStatus.BookStatusEntity;
import com.example.booo.Review.ReviewEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "book", schema = "public", catalog = "BooDatabase")
@NamedQueries({
        @NamedQuery(name = "book.findById", query = "select b from BookEntity b where b.id = ?1"),
        @NamedQuery(name = "book.findAll", query = "select b from BookEntity b")
}
)
public class BookEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;
    @Basic
    @Column(name = "isbn", nullable = false, length = -1)
    private String isbn;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "picture", nullable = true, length = -1)
    private String picture;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<BookAuthorsEntity> bookAuthorsById;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<BookGenresEntity> bookGenresById;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<BookStatusEntity> bookStatusesById;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<ReviewEntity> reviewsById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (picture != null ? !picture.equals(that.picture) : that.picture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }

    public Collection<BookAuthorsEntity> getBookAuthorsById() {
        return bookAuthorsById;
    }

    public void setBookAuthorsById(Collection<BookAuthorsEntity> bookAuthorsById) {
        this.bookAuthorsById = bookAuthorsById;
    }

    public Collection<BookGenresEntity> getBookGenresById() {
        return bookGenresById;
    }

    public void setBookGenresById(Collection<BookGenresEntity> bookGenresById) {
        this.bookGenresById = bookGenresById;
    }

    public Collection<BookStatusEntity> getBookStatusesById() {
        return bookStatusesById;
    }

    public void setBookStatusesById(Collection<BookStatusEntity> bookStatusesById) {
        this.bookStatusesById = bookStatusesById;
    }

    public Collection<ReviewEntity> getReviewsById() {
        return reviewsById;
    }

    public void setReviewsById(Collection<ReviewEntity> reviewsById) {
        this.reviewsById = reviewsById;
    }
}

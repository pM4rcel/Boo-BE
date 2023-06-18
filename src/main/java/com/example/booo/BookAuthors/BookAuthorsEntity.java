package com.example.booo.BookAuthors;

import com.example.booo.Author.AuthorEntity;
import com.example.booo.Book.BookEntity;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book_authors", schema = "public", catalog = "BooDatabase")
@IdClass(BookAuthorsEntityPK.class)
@NamedQueries({
        @NamedQuery(name = "book_authors.findByBookId",
        query = "select b from BookAuthorsEntity b where b.bookId = ?1"),
        @NamedQuery(name = "book_authors.findByAuthorID",
        query = "select b from BookAuthorsEntity b where b.authorId = ?1")
})
public class BookAuthorsEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "book_id", nullable = false)
    private Long bookId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "author_id", nullable = false)
    private Long authorId;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private BookEntity bookByBookId;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private AuthorEntity authorByAuthorId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookAuthorsEntity that = (BookAuthorsEntity) o;

        if (bookId != null ? !bookId.equals(that.bookId) : that.bookId != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId != null ? bookId.hashCode() : 0;
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        return result;
    }

    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    public AuthorEntity getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(AuthorEntity authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }
}

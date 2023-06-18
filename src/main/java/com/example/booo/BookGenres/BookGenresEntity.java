package com.example.booo.BookGenres;

import com.example.booo.Book.BookEntity;
import com.example.booo.Genre.GenreEntity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "book_genres", schema = "public", catalog = "BooDatabase")
@IdClass(BookGenresEntityPK.class)
@NamedQueries({
        @NamedQuery(name = "book_genre.findByGenreId",
        query = "select b from BookGenresEntity b where b.genreId = ?1"),
        @NamedQuery(name = "book_genre.findByBookId",
        query = "select b from BookGenresEntity b where b.bookId = ?1")
})
public class BookGenresEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "book_id", nullable = false)
    private Long bookId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "genre_id", nullable = false)
    private Long genreId;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private BookEntity bookByBookId;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    private GenreEntity genreByGenreId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookGenresEntity that = (BookGenresEntity) o;

        if (bookId != null ? !bookId.equals(that.bookId) : that.bookId != null) return false;
        if (genreId != null ? !genreId.equals(that.genreId) : that.genreId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId != null ? bookId.hashCode() : 0;
        result = 31 * result + (genreId != null ? genreId.hashCode() : 0);
        return result;
    }

    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    public GenreEntity getGenreByGenreId() {
        return genreByGenreId;
    }

    public void setGenreByGenreId(GenreEntity genreByGenreId) {
        this.genreByGenreId = genreByGenreId;
    }
}

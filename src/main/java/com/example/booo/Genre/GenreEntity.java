package com.example.booo.Genre;

import com.example.booo.BookGenres.BookGenresEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "genre", schema = "public", catalog = "BooDatabase")
@NamedQuery(name = "genres.findById", query = "select a from GenreEntity a where a.id = ?1 ")
@NamedQuery(name = "genres.findAll", query = "select a from GenreEntity  a")
public class GenreEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;
    @OneToMany(mappedBy = "genreByGenreId")
    private Collection<BookGenresEntity> bookGenresById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreEntity that = (GenreEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<BookGenresEntity> getBookGenresById() {
        return bookGenresById;
    }

    public void setBookGenresById(Collection<BookGenresEntity> bookGenresById) {
        this.bookGenresById = bookGenresById;
    }
}

package com.example.booo.Comment;

import com.example.booo.ReviewComment.ReviewCommentEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "comment_", schema = "public", catalog = "BooDatabase")
@NamedQueries({
        @NamedQuery(name = "comment.findById",
        query = "select c from CommentEntity c where c.id = ?1"),
        @NamedQuery(name = "comment.findAll",
        query = "select c from CommentEntity c")
})
public class CommentEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "createdat", nullable = true)
    private Timestamp createdat;
    @OneToMany(mappedBy = "commentByCommentId")
    private Collection<ReviewCommentEntity> reviewCommentsById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createdat != null ? !createdat.equals(that.createdat) : that.createdat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdat != null ? createdat.hashCode() : 0);
        return result;
    }

    public Collection<ReviewCommentEntity> getReviewCommentsById() {
        return reviewCommentsById;
    }

    public void setReviewCommentsById(Collection<ReviewCommentEntity> reviewCommentsById) {
        this.reviewCommentsById = reviewCommentsById;
    }
}

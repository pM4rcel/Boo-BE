package com.example.booo.User;

import com.example.booo.BookStatus.BookStatusEntity;
import com.example.booo.GroupMembers.GroupMembersEntity;
import com.example.booo.ReviewComment.ReviewCommentEntity;
import com.example.booo.Review.ReviewEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "public", catalog = "BooDatabase")
@NamedQueries({
        @NamedQuery(name = "user.findById",
        query = "SELECT user FROM UserEntity user WHERE user.id = ?1"),
        @NamedQuery(name = "user.findAll",
        query = "SELECT user FROM UserEntity user")
})
public class UserEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;
    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;
    @Basic
    @Column(name = "pictureurl", nullable = true, length = -1)
    private String pictureurl;
    @Basic
    @Column(name = "createdat", nullable = true)
    private Timestamp createdat;
    @Basic
    @Column(name = "updatedat", nullable = true)
    private Timestamp updatedat;
    @Basic
    @Column(name = "verified", nullable = true)
    private Boolean verified;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<BookStatusEntity> bookStatusesById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<GroupMembersEntity> groupMembersById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<ReviewEntity> reviewsById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<ReviewCommentEntity> reviewCommentsById;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public Timestamp getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Timestamp createdat) {
        this.createdat = createdat;
    }

    public Timestamp getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Timestamp updatedat) {
        this.updatedat = updatedat;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (pictureurl != null ? !pictureurl.equals(that.pictureurl) : that.pictureurl != null) return false;
        if (createdat != null ? !createdat.equals(that.createdat) : that.createdat != null) return false;
        if (updatedat != null ? !updatedat.equals(that.updatedat) : that.updatedat != null) return false;
        if (verified != null ? !verified.equals(that.verified) : that.verified != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (pictureurl != null ? pictureurl.hashCode() : 0);
        result = 31 * result + (createdat != null ? createdat.hashCode() : 0);
        result = 31 * result + (updatedat != null ? updatedat.hashCode() : 0);
        result = 31 * result + (verified != null ? verified.hashCode() : 0);
        return result;
    }

    public Collection<BookStatusEntity> getBookStatusesById() {
        return bookStatusesById;
    }

    public void setBookStatusesById(Collection<BookStatusEntity> bookStatusesById) {
        this.bookStatusesById = bookStatusesById;
    }

    public Collection<GroupMembersEntity> getGroupMembersById() {
        return groupMembersById;
    }

    public void setGroupMembersById(Collection<GroupMembersEntity> groupMembersById) {
        this.groupMembersById = groupMembersById;
    }

    public Collection<ReviewEntity> getReviewsById() {
        return reviewsById;
    }

    public void setReviewsById(Collection<ReviewEntity> reviewsById) {
        this.reviewsById = reviewsById;
    }

    public Collection<ReviewCommentEntity> getReviewCommentsById() {
        return reviewCommentsById;
    }

    public void setReviewCommentsById(Collection<ReviewCommentEntity> reviewCommentsById) {
        this.reviewCommentsById = reviewCommentsById;
    }
}

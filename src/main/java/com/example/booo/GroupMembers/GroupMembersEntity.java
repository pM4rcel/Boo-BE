package com.example.booo.GroupMembers;

import com.example.booo.Group.GroupEntity;
import com.example.booo.User.UserEntity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "group_members", schema = "public", catalog = "BooDatabase")
@IdClass(GroupMembersEntityPK.class)
@NamedQuery(name = "groupMembers.findByUserId", query = "select a from GroupMembersEntity a where a.userId = ?1 ")
@NamedQuery(name = "groupMembers.findByGroupId", query = "select a from GroupMembersEntity a where a.groupId = ?1 ")
@NamedQuery(name = "groupMembers.findAll", query = "select a from GroupMembersEntity  a")
public class GroupMembersEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "group_id", nullable = false)
    private Long groupId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity usersByUserId;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    private GroupEntity groupByGroupId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupMembersEntity that = (GroupMembersEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        return result;
    }

    public UserEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UserEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    public GroupEntity getGroupByGroupId() {
        return groupByGroupId;
    }

    public void setGroupByGroupId(GroupEntity groupByGroupId) {
        this.groupByGroupId = groupByGroupId;
    }
}

package com.example.booo.Group;

import com.example.booo.GroupMembers.GroupMembersEntity;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "group_", schema = "public", catalog = "BooDatabase")
@NamedQuery(name = "groups.findById", query = "select a from GroupEntity a where a.id = ?1 ")
@NamedQuery(name = "groups.findAll", query = "select a from GroupEntity a")
public class GroupEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "createdat", nullable = true)
    private Timestamp createdat;
    @Basic
    @Column(name = "members_count", nullable = true)
    private Integer membersCount;
    @OneToMany(mappedBy = "groupByGroupId")
    private Collection<GroupMembersEntity> groupMembersById;

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

    public Integer getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(Integer membersCount) {
        this.membersCount = membersCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupEntity that = (GroupEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createdat != null ? !createdat.equals(that.createdat) : that.createdat != null) return false;
        if (membersCount != null ? !membersCount.equals(that.membersCount) : that.membersCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdat != null ? createdat.hashCode() : 0);
        result = 31 * result + (membersCount != null ? membersCount.hashCode() : 0);
        return result;
    }

    public Collection<GroupMembersEntity> getGroupMembersById() {
        return groupMembersById;
    }

    public void setGroupMembersById(Collection<GroupMembersEntity> groupMembersById) {
        this.groupMembersById = groupMembersById;
    }
}

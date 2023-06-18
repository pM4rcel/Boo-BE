package com.example.booo.GroupMembers;

import com.example.booo.DataBase.DataBase;
import com.example.booo.Group.GroupEntity;
import com.example.booo.Repository;

import java.util.List;

public abstract class GroupMembersRepository implements Repository<GroupMembersEntity, Long> {
    public List<GroupMembersEntity> findByUserId(Long aLong){
        return DataBase.getInstance().createNamedQuery("groupMembers.findByUserId", GroupMembersEntity.class)
                .setParameter(1, aLong)
                .getResultList();
    }
    public List<GroupMembersEntity> findByGroupId(Long aLong){
        return DataBase.getInstance().createNamedQuery("groupMembers.findByGroupId", GroupMembersEntity.class)
                .setParameter(1, aLong).getResultList();
    }

    @Override
    public List<GroupMembersEntity> findAll() {
        return DataBase.getInstance().createNamedQuery("groupMembers.findAll", GroupMembersEntity.class)
                .getResultList();
    }
}

package com.example.booo.GroupMembers;

import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

public abstract class GroupMembersRepository implements Repository<GroupMembersEntity, Long> {
    @Override
    public void deleteByID(Long aLong) {
        DataBase.getInstance().getTransaction().begin();
        GroupMembersEntity g = findByID(aLong);
        DataBase.getInstance().remove(g);
        DataBase.getInstance().getTransaction().commit();
    }
}

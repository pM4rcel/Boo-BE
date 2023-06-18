package com.example.booo.Group;

import com.example.booo.BookGenres.BookGenresEntity;
import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

import javax.xml.crypto.Data;

public abstract class GroupRepository implements Repository<GroupEntity, Long> {
    @Override
    public GroupEntity findByID(Long aLong) {
        return DataBase.getInstance().createNamedQuery("groups.findById", GroupEntity.class)
                .setParameter(1, aLong)
                .getSingleResult();
    }
    @Override
    public void deleteByID(Long aLong) {
        DataBase.getInstance().getTransaction().begin();
        GroupEntity g = findByID(aLong);
        DataBase.getInstance().remove(g);
        DataBase.getInstance().getTransaction().commit();
    }
}

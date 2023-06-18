package com.example.booo.User;

import com.example.booo.DataBase.DataBase;
import com.example.booo.Repository;

import java.util.List;
class UserRepository implements Repository<UserEntity, Long> {
    @Override
    public UserEntity findByID(Long aLong) {
        return DataBase.getInstance().find(UserEntity.class, aLong);
    }

    @Override
    public void deleteByID(Long aLong) {
        DataBase.getInstance().getTransaction().begin();
        UserEntity u = findByID(aLong);
        DataBase.getInstance().remove(u);
        DataBase.getInstance().getTransaction().commit();
    }
    @Override
    public List<UserEntity> findAll() {
        var query = DataBase.getInstance().createNamedQuery("user.findAll", UserEntity.class);
        return query.getResultList();
    }
}

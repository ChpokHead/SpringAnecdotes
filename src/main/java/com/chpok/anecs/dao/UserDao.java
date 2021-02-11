package com.chpok.anecs.dao;

import com.chpok.anecs.models.Anec;
import com.chpok.anecs.models.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends CrudDao<User>{
    List<Anec> getFavAnecListFromUser();
    boolean checkIfUserExist(String username, String password);
    Optional<User> getUserByUsername(String username);
}

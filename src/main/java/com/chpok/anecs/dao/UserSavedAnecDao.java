package com.chpok.anecs.dao;

import com.chpok.anecs.models.Anec;
import com.chpok.anecs.models.UserSavedAnec;

import java.util.List;

public interface UserSavedAnecDao extends CrudDao<UserSavedAnec>{
    void save(UserSavedAnec userSavedAnec);
    List<Anec> getSavedAnecsByUserId(Long id);
}

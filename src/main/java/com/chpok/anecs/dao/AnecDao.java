package com.chpok.anecs.dao;

import com.chpok.anecs.models.Anec;

import java.io.IOException;
import java.util.Optional;

public interface AnecDao extends CrudDao<Anec>{
    Optional<Anec> getRandomAnec();
    void initDb() throws IOException;
}

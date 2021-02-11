package com.chpok.anecs.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    void save(T t);
    Optional<T> get(Long id);
    void update(T t);
    void delete(Long id);

    List<T> getAll();
}

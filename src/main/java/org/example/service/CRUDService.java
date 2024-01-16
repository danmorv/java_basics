package org.example.service;

import java.util.Collection;

public interface CRUDService<T> {
    T gerByID(Integer id);

    Collection<T> getAll();

    void create(T news);

    void update(Integer id, T news);

    void delete(Integer id);
}

package org.example.newscount.service;

import java.util.Collection;

public interface CRUDService<T> {
    T getById(Integer id);
    Collection<T> getAll();
    void create(T news);
    void update(T news);
    void delete(Integer id);
}

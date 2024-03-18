package org.example.fibonacci.services;

import java.util.Collection;
import java.util.TreeMap;

public interface FinabocciServices<T> {
    T getById(Integer id);
    Collection<T> getAll();
    void create(Integer index);
}

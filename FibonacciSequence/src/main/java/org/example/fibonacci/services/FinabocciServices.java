package org.example.fibonacci.services;

import java.util.Collection;

public interface FinabocciServices<T> {
    T getById(Integer id);
    Collection<T> getAll();
    void create(T finabocci);
}

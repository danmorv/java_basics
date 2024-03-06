package org.example.fibonacci.services;

import org.example.fibonacci.entity.Finabocci;

import java.util.Collection;

public interface FinabocciServ {
    Collection getNumber();
    void create(int index);
}

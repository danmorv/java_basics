package org.example.fibonacci.repositories;

import org.example.fibonacci.entity.Finabocci;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinabocciRepository extends JpaRepository<Finabocci, Integer> {
}

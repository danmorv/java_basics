package org.example.fibonacci.repositories;

import org.example.fibonacci.entity.Finabocci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinabocciRepository extends JpaRepository<Finabocci, Integer> {
}

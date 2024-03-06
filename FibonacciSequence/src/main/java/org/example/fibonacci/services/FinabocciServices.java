package org.example.fibonacci.services;

import lombok.extern.slf4j.Slf4j;
import org.example.fibonacci.FinabocciCalculator;
import org.example.fibonacci.entity.Finabocci;
import org.example.fibonacci.repositories.FinabocciRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
public class FinabocciServices implements FinabocciServ{
    private FinabocciRepository repository;

    public FinabocciServices(FinabocciRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Finabocci> getNumber() {
        log.info("Get");
        return repository.findAll();
    }

    @Override
    public void create(int index) {
        log.info("Create");
        Finabocci finabocci = new Finabocci();
        FinabocciCalculator calculator = new FinabocciCalculator();
        finabocci.setIndex(index);
        finabocci.setValue(calculator.getValue(index));
        repository.save(finabocci);
    }
}

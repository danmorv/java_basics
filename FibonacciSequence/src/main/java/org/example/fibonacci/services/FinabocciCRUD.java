package org.example.fibonacci.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.fibonacci.FinabocciCalculator;
import org.example.fibonacci.dto.FinabocciDto;
import org.example.fibonacci.entity.Finabocci;
import org.example.fibonacci.repositories.FinabocciRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FinabocciCRUD implements FinabocciServices<FinabocciDto>{
    private final FinabocciRepository repository;

    @Override
    public FinabocciDto getById(Integer id) {
        log.info("Get by id");
        Finabocci finabocci = repository.findById(id).orElseThrow();
        return mapToDto(finabocci);
    }

    @Override
    public Collection<FinabocciDto> getAll() {
        log.info("Get all");
       return repository.findAll().stream().map(FinabocciCRUD::mapToDto).toList();
    }

    @Override
    public void create(Integer index) {
        log.info("Create");
        FinabocciCalculator calculator = new FinabocciCalculator();
        Finabocci finabocci = new Finabocci();
        finabocci.setIndex(index);
        finabocci.setValue(calculator.calculatNumber(index));
        repository.save(finabocci);
        repository.toString();
    }
    public static FinabocciDto mapToDto(Finabocci finabocci) {
        FinabocciDto finabocciDto = new FinabocciDto();
        finabocciDto.setId(finabocci.getId());
        finabocciDto.setIndex(finabocci.getIndex());
        finabocciDto.setValue(finabocci.getValue());
        return finabocciDto;
    }
    public static Finabocci mapToEntity(FinabocciDto finabocciDto) {
        Finabocci finabocci = new Finabocci();
        finabocci.setId(finabocciDto.getId());
        finabocci.setIndex(finabocciDto.getIndex());
        finabocci.setValue(finabocciDto.getValue());
        return finabocci;
    }
}

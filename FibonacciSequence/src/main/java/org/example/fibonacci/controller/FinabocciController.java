package org.example.fibonacci.controller;

import org.example.fibonacci.dto.FinabocciDto;
import org.example.fibonacci.entity.Finabocci;
import org.example.fibonacci.services.FinabocciCRUD;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.TreeMap;

@RestController
@RequestMapping(name = "/finabocci")
public class FinabocciController {
    private final FinabocciCRUD finabocciCRUD;

    public FinabocciController(FinabocciCRUD finabocciCRUD) {
        this.finabocciCRUD = finabocciCRUD;
    }
    @GetMapping("/{id}")
    public FinabocciDto getFinabocciById(@PathVariable Integer id) {
        return finabocciCRUD.getById(id);
    }
    @GetMapping
    public Collection<FinabocciDto> getAll() {
        return finabocciCRUD.getAll();
    }
    @PostMapping("/finabocci/{index}")
    public void create(@PathVariable Integer index) {
        finabocciCRUD.create(index);
    }
}

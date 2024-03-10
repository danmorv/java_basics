package org.example.fibonacci.controller;

import org.example.fibonacci.dto.FinabocciDto;
import org.example.fibonacci.services.FinabocciCRUD;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(name = "index")
public class FinabocciController {
    private final FinabocciCRUD finabocciCRUD;

    public FinabocciController(FinabocciCRUD finabocciCRUD) {
        this.finabocciCRUD = finabocciCRUD;
    }
    @GetMapping("/id")
    public FinabocciDto getFinabocciById(@PathVariable Integer id) {
        return finabocciCRUD.getById(id);
    }
    @GetMapping
    public Collection<FinabocciDto> getAll() {
        return finabocciCRUD.getAll();
    }
    @PostMapping("/index")
    public void create(FinabocciDto finabocciDto) {
        finabocciCRUD.create(finabocciDto);
    }
}

package org.example.fibonacci.controller;

import org.example.fibonacci.services.FinabocciServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index")
public class FinabocciController {
    private final FinabocciServices finabocciServices;

    public FinabocciController(FinabocciServices finabocciServices) {
        this.finabocciServices = finabocciServices;
    }
    @PostMapping("/{index}")
    public void createNumbers(@PathVariable Integer index) {
        finabocciServices.create(index);
    }
    @GetMapping("/")
    public void getNumber() {
        finabocciServices.getNumber();
    }
}

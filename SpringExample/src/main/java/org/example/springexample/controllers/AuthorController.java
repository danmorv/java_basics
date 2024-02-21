package org.example.springexample.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springexample.dto.AuthorDto;
import org.example.springexample.services.AuthorCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorCRUDService authorCRUDService;
    @GetMapping
    public Collection<AuthorDto> getAll() {
        return authorCRUDService.getAll();
    }
    @PostMapping
    public void create(@RequestBody AuthorDto authorDto) {
        authorCRUDService.create(authorDto);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody AuthorDto authorDto) {
        authorDto.setId(id);
        authorCRUDService.update(authorDto);
    }
    @DeleteMapping
    public void delete(@PathVariable Integer id) {
         authorCRUDService.delete(id);
    }
}

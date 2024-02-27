package org.example.newscount.controller;

import lombok.RequiredArgsConstructor;
import org.example.newscount.dto.CategoryDto;
import org.example.newscount.entity.Category;
import org.example.newscount.service.CategoryCRUDService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryCRUDService categoryCRUDService;
    @GetMapping
    public Collection<CategoryDto> getAll() {
        return categoryCRUDService.getAll();
    }
    @PostMapping
    public void create(@RequestBody CategoryDto categoryDto) {
        categoryCRUDService.create(categoryDto);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(id);
        categoryCRUDService.update(categoryDto);
    }
    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        categoryCRUDService.delete(id);
    }
}

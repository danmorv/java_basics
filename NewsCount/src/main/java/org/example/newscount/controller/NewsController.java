package org.example.newscount.controller;

import org.example.newscount.dto.NewsDto;
import org.example.newscount.service.NewsCRUDService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/news")
public class NewsController {
    private final NewsCRUDService newsCRUDService;
    public NewsController(NewsCRUDService newsCRUDService) {
        this.newsCRUDService = newsCRUDService;
    }
    @GetMapping("/{id}")
    public NewsDto getNewsById(@PathVariable Integer id) {
        return newsCRUDService.getById(id);
    }
    @GetMapping
    public Collection<NewsDto> getAll() {
        return newsCRUDService.getAll();
    }
    @PostMapping
    public void createNews(@RequestBody NewsDto newsDto) {
        newsCRUDService.create(newsDto);
    }
    @PutMapping("/{id}")
    public void updateNews(@PathVariable Integer id, @RequestBody NewsDto newsDto) {
        newsCRUDService.update(newsDto);
    }
    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Integer id) {
        newsCRUDService.delete(id);
    }


}

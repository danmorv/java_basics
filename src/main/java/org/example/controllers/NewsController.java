package org.example.controllers;

import org.example.dto.NewsDTO;
import org.example.service.NewsCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/news")
public class NewsController {
    private NewsCRUDService service;

    public NewsController(NewsCRUDService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public NewsDTO getNews(@PathVariable Integer id) {
        return service.gerByID(id);
    }

    @GetMapping
    public Collection<NewsDTO> getAllNews() {
        return service.getAll();
    }

    @PostMapping
    public void createNews(@RequestBody NewsDTO newsDTO) {
        service.create(newsDTO);
    }

    @PutMapping("/{id}")
    public void updateNews(@PathVariable Integer id, @RequestBody NewsDTO newsDTO) {
        service.update(id, newsDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Integer id) {
        service.delete(id);
    }
}

package org.example.newscount.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.newscount.dto.NewsDto;
import org.example.newscount.entity.Category;
import org.example.newscount.entity.News;
import org.example.newscount.repositories.CategoryRepository;
import org.example.newscount.repositories.NewsRepositoy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
@Service
@RequiredArgsConstructor
@Slf4j
public class NewsCRUDService implements CRUDService<NewsDto> {
    private final NewsRepositoy repository;
    private final CategoryRepository categoryRepository;
    @Override
    public NewsDto getById(Integer id) {
        log.info("Get by id");
        News news = repository.findById(id).orElseThrow();
        return mapToDto(news);
    }

    @Override
    public Collection<NewsDto> getAll() {
        log.info("Get all");
        return repository.findAll()
                .stream()
                .map(NewsCRUDService::mapToDto)
                .toList();
    }

    @Override
    public void create(NewsDto newsDto) {
        log.info("Create");
        News news = mapToEntity(newsDto);
        Integer categoryId = newsDto.getCategoryId();
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        news.setCategory(category);
        repository.save(news);
    }

    @Override
    public void update(NewsDto newsDto) {
        log.info("Update");
        News news = mapToEntity(newsDto);
        Integer categoryId = newsDto.getCategoryId();
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        news.setCategory(category);
        repository.save(news);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete");
        repository.deleteById(id);
    }
    public static NewsDto mapToDto(News news) {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setText(news.getText());
        newsDto.setTitle(news.getTitle());
        newsDto.setCategoryId(news.getId());
        newsDto.setCategoryName(news.getCategory().getName());
        newsDto.getTime();
        return newsDto;
    }
    public static News mapToEntity(NewsDto newsDto) {
        News news = new News();
        news.setId(newsDto.getId());
        news.setText(newsDto.getText());
        news.setTitle(newsDto.getTitle());

        return news;
    }
}

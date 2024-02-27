package org.example.newscount.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.newscount.dto.NewsDto;
import org.example.newscount.entity.News;
import org.example.newscount.repositories.NewsRepositoy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
@Service
@RequiredArgsConstructor
@Slf4j
public class NewsCRUDService implements CRUDService<NewsDto> {
    private final NewsRepositoy repositoy;
    @Override
    public NewsDto getById(Integer id) {
        log.info("Get by id");
        News news = repositoy.findById(id).orElseThrow();
        return mapToDto(news);
    }

    @Override
    public Collection<NewsDto> getAll() {
        log.info("Get all");
        return repositoy.findAll()
                .stream()
                .map(NewsCRUDService::mapToDto)
                .toList();
    }

    @Override
    public void create(NewsDto newsDto) {
        log.info("Create");
        News news = mapToEntity(newsDto);
        repositoy.save(news);
    }

    @Override
    public void update(NewsDto newsDto) {
        log.info("Update");
        News news = mapToEntity(newsDto);
        repositoy.save(news);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete");
        repositoy.deleteById(id);
    }
    public static NewsDto mapToDto(News news) {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setText(news.getText());
        newsDto.setTitle(news.getTitle());
        newsDto.setCategoryName(newsDto.getCategoryName());

        return newsDto;
    }
    public static News mapToEntity(NewsDto newsDto) {
        News news = new News();
        news.setId(newsDto.getId());
        news.setText(newsDto.getText());
        news.setTitle(newsDto.getTitle());
        news.setTime(LocalDateTime.now());
        return news;
    }
}

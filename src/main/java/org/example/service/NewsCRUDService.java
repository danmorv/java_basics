package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.NewsDTO;
import org.example.entity.News;
import org.example.repositoryes.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsCRUDService implements CRUDService<NewsDTO> {
     private final NewsRepository repository;


    @Override
    public NewsDTO gerByID(Integer id) {
        log.info("Get");
        News news = repository.findById(id).orElseThrow();
        return mapToDTO(news);
    }

    @Override
    public Collection<NewsDTO> getAll() {
        log.info("All");
        return repository
                .findAll()
                .stream()
                .map(NewsCRUDService::mapToDTO)
                .toList();
    }

    @Override
    public void create(NewsDTO news) {
        log.info("Create");
        News news1 = mapToEntity(news);
        repository.save(news1);
    }

    @Override
    public void update(NewsDTO news) {
        log.info("Update");
        News news1 = mapToEntity(news);
        repository.save(news1);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete");
        repository.deleteById(id);
    }

    public static NewsDTO mapToDTO(News news){
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(news.getId());
        newsDTO.setText(news.getText());
        return newsDTO;
    }
    public static News mapToEntity(NewsDTO newsDTO) {
        News news = new News();
        news.setId(news.getId());
        news.setText(news.getText());
        return news;

    }
}

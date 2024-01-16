package org.example.service;

import org.example.dto.NewsDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;

@Service
public class NewsCRUDService implements CRUDService<NewsDTO> {
    private final TreeMap<Integer, NewsDTO> listNews = new TreeMap<>();

    @Override
    public NewsDTO gerByID(Integer id) {
        System.out.println("Get");
        return listNews.get(id);
    }

    @Override
    public Collection<NewsDTO> getAll() {
        System.out.println("All");
        return listNews.values();
    }

    @Override
    public void create(NewsDTO news) {
        System.out.println("Create");
        int id = (listNews.isEmpty() ? 0 : listNews.lastKey()) + 1;
        news.setId(id);
        listNews.put(id, news);
    }

    @Override
    public void update(Integer id, NewsDTO news) {
        System.out.println("Update");
        news.setId(id);
        listNews.put(id, news);
    }

    @Override
    public void delete(Integer id) {
        System.out.println("Delete");
        listNews.remove(id);
    }
}

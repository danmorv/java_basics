package org.example.springexample.services;

import lombok.Setter;
import org.example.springexample.dto.CommentDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;
@Service

public class CommentCRUDSerice implements CRUDService<CommentDto> {
    @Value("${comment.length.max}")
    private Integer maxLength;
    private TreeMap<Integer, CommentDto> storage = new TreeMap<>();
    @Override
    public CommentDto getById(Integer id) {
        System.out.println("Get by id: " + id);
        return storage.get(id);
    }

    @Override
    public Collection<CommentDto> getAll() {
        System.out.println("Get all");
        return storage.values();
    }

    @Override
    public void create(CommentDto item) {
        System.out.println("Create");
        int nextId = ( storage.isEmpty() ? 0 :  storage.lastKey()) + 1;
        item.setId(nextId);
        if (item.getText().length() > maxLength) {
            throw new RuntimeException("Comment to long");
        }
        storage.put(nextId, item);
    }

    @Override
    public void update(Integer id, CommentDto item) {
        System.out.println("Put");
        if (item.getText().length() > maxLength) {
            throw new RuntimeException("Comment to long");
        }
        item.setId(id);
        storage.put(id, item);
    }

    @Override
    public void delete(Integer id) {
        System.out.println("Delete");
        storage.remove(id);
    }
}

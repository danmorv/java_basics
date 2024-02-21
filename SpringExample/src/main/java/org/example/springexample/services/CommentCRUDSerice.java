package org.example.springexample.services;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.springexample.dto.CommentDto;
import org.example.springexample.entity.Author;
import org.example.springexample.entity.Comment;
import org.example.springexample.repositories.AuthorRepository;
import org.example.springexample.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;
@Service
@RequiredArgsConstructor
@Slf4j
public class CommentCRUDSerice implements CRUDService<CommentDto> {

    private final CommentRepository repository;
    private final AuthorRepository authorRepository;

    @Override
    public CommentDto getById(Integer id) {
        log.info("Get by id: " + id);
        Comment comment = repository.findById(id).orElseThrow();
        return mapToDto(comment);
    }

    @Override
    public Collection<CommentDto> getAll() {
        log.info("Get all");
        return repository.findAll()
                .stream()
                .map(CommentCRUDSerice::mapToDto)
                .toList();

    }

    @Override
    public void create(CommentDto commentDto) {
        log.info("Create");
        Comment comment = mapToEntity(commentDto);
        Integer authorId = commentDto.getAuthorID();
        Author author = authorRepository.findById(authorId).orElseThrow();
        comment.setAuthor(author);
        repository.save(comment);
    }

    @Override
    public void update(CommentDto commentDto) {
        log.info("Put");
        Comment comment = mapToEntity(commentDto);
        Integer authorId = commentDto.getAuthorID();
        Author author = authorRepository.findById(authorId).orElseThrow();
        comment.setAuthor(author);
        repository.save(comment);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete");
        repository.deleteById(id);
    }
    public static CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setText(comment.getText());
        commentDto.setAuthorID(comment.getAuthor().getId());
        return commentDto;
    }
    public static Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setText(commentDto.getText());

        return comment;
    }
}

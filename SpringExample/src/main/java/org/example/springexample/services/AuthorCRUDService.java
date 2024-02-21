package org.example.springexample.services;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.springexample.dto.AuthorDto;
import org.example.springexample.entity.Author;
import org.example.springexample.entity.Comment;
import org.example.springexample.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorCRUDService implements CRUDService<AuthorDto> {

    private final AuthorRepository authorRepository;
    @Override
    public AuthorDto getById(Integer id) {
        log.info("Get by id: " + id);
        return mapToDto(authorRepository.findById(id).orElseThrow());
    }

    @Override
    public Collection getAll() {
        return authorRepository
                .findAll()
                .stream()
                .map(AuthorCRUDService::mapToDto)
                .toList();
    }

    @Override
    public void create(AuthorDto authorDto) {
        Author author = mapToEntity(authorDto);
        authorRepository.save(author);
    }

    @Override
    public void update(AuthorDto authorDto) {
        Author author = mapToEntity(authorDto);
        authorRepository.save(author);
    }

    @Override
    public void delete(Integer id) {
        authorRepository.deleteById(id);
    }
    public static Author mapToEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setLastName(authorDto.getLastName());
        author.setRating(authorDto.getRating());
        author.setCommentList(authorDto.getCommentList());
        return author;
    }
    public static AuthorDto mapToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setLastName(author.getLastName());
        authorDto.setRating(author.getRating());
        authorDto.setCommentList(author.getCommentList());
        return authorDto;
    }
}

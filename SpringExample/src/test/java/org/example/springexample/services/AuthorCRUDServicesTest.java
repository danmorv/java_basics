package org.example.springexample.services;

import org.example.springexample.dto.AuthorDto;
import org.example.springexample.entity.Author;
import org.example.springexample.repositories.AuthorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthorCRUDServicesTest {
    private final AuthorRepository repository = Mockito.mock(AuthorRepository.class);
    private final AuthorCRUDService service = new AuthorCRUDService(repository);

    @Test
    @DisplayName("Test get by Id")
    public void testGetById() {
        int authorId = 1;
        Author author =new Author();
        author.setId(authorId);
        author.setCommentList(List.of());
        when(repository.findById(authorId)).thenReturn(Optional.of(author));
        AuthorDto authorDto = service.getById(authorId);
        assertEquals(authorId, authorDto.getId());
        verify(repository, times(1)).findById(authorId);
    }
}

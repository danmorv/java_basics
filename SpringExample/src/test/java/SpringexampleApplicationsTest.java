import org.checkerframework.checker.units.qual.A;
import org.example.springexample.dto.CommentDto;
import org.example.springexample.entity.Author;
import org.example.springexample.entity.Comment;
import org.example.springexample.repositories.AuthorRepository;
import org.example.springexample.repositories.CommentRepository;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringexampleApplicationsTest {
    @LocalServerPort
    private Integer port;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private AuthorRepository authorRepository;
    private TestRestTemplate template = new TestRestTemplate();

    public static PostgreSQLContainer<?> container= new PostgreSQLContainer<>("postgres:14");
    @BeforeAll
    public static void beforeAll() {
        container.start();
    }
    @AfterAll
    public static void afterAll() {
        container.stop();
    }
    @DynamicPropertySource
    public static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasourse.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }
    @BeforeEach
    public void fillingDataBase() {
        Comment comment = new Comment();
        comment.setText("Text comment");
        comment.setAuthor(authorRepository.save(new Author()));
        commentRepository.save(comment);
    }
    @AfterEach
    public void clearDataBase() {
        authorRepository.deleteAll();
    }
    @Test
    public void testGetCommentById() {
        ResponseEntity<CommentDto> response = template.getRestTemplate()
                .getForEntity("http://localhost:" + port + "/comment/1", CommentDto.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(1, response.getBody().getId());
        assertEquals("Text comment", response.getBody().getText());
    }

}

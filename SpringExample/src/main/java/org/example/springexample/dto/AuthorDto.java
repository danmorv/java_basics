package org.example.springexample.dto;

import lombok.Data;
import org.example.springexample.entity.Comment;

import java.util.List;
@Data
public class AuthorDto {
    private Integer id;
    private String name;
    private String lastName;
    private Long rating;
    private List<Comment> commentList;
}

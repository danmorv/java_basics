package org.example.springexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springexample.entity.Author;

@NoArgsConstructor
@Getter
@Setter
public class CommentDto {
    private Integer id;
    private String text;
    private Integer authorID;
}

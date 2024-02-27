package org.example.newscount.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class NewsDto {
    private Integer id;
    private String title;
    private String text;
    private LocalDateTime time = LocalDateTime.now();
    private Integer categoryId;
    private String categoryName;
}

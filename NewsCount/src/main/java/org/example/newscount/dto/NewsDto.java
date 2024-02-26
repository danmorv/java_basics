package org.example.newscount.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NewsDto {
    private Integer id;
    private String title;
    private String text;
    private Integer categoryId;

}

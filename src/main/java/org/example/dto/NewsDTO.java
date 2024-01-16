package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class NewsDTO {
    private Integer id;
    private String title;
    private String text;
    private LocalDateTime date;
}

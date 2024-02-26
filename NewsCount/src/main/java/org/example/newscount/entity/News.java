package org.example.newscount.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
@Getter
@Setter
public class News {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;
    @JoinColumn(name = "category_id")
    @ManyToOne
    private String categoty;
    @CreationTimestamp
    @Column(name = "time")
    private LocalDateTime time;
}

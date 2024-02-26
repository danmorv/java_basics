package org.example.newscount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NewsCount {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NewsCount.class, args);
    }
}
package org.example.newscount.repositories;

import org.example.newscount.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepositoy extends JpaRepository<News, Integer> {
}

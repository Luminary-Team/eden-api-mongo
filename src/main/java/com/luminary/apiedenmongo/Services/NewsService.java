package com.luminary.apiedenmongo.Services;

import com.luminary.apiedenmongo.Repositories.NewsRepository;
import com.luminary.apiedenmongo.Models.Collections.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NewsService {
    private final NewsRepository newsRepository;

    public List<News> getAllNews() {
        log.info("[NEWS] Fetching all news");
        return newsRepository.findAll();
    }

    public Optional<News> getNewsById(String id) {
        log.info("[NEWS] Fetching news by ID: {}", id);
        return newsRepository.findById(id);
    }
}

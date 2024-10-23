package com.luminary.apiedenmongo.Services;

import com.luminary.apiedenmongo.Repositories.NewsRepository;
import com.luminary.apiedenmongo.Models.Database.News;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
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
        if (ObjectId.isValid(id)) {
            log.info("[NEWS] Valid ObjectId: " + id);
            return newsRepository.findById(new ObjectId(id));
        } else {
            log.warn("[NEWS] Invalid ObjectId: " + id);
            return Optional.empty();
        }
    }
}

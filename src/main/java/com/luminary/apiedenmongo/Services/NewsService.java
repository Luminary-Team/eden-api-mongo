package com.luminary.apiedenmongo.Services;

import com.luminary.apiedenmongo.Models.Database.News;
import com.luminary.apiedenmongo.Models.Response.ForumResponse;
import com.luminary.apiedenmongo.Models.Response.NewsResponse;
import com.luminary.apiedenmongo.Repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NewsService {
    private final NewsRepository newsRepository;

    public List<NewsResponse> getAllNews() {
        log.info("[NEWS] Fetching all news");
        return newsRepository.findAll().stream()
                .map(NewsResponse::new)
                .toList();
    }

    public ResponseEntity<NewsResponse> getNewsById(String id) {
        log.info("[NEWS] Fetching news by ID: {}", id);
        if (ObjectId.isValid(id)) {
            log.info("[NEWS] Valid ObjectId: {}", id);
            Optional<News> newsOptional = newsRepository.findById(new ObjectId(id));
            if (newsOptional.isPresent()) {
                NewsResponse response = new NewsResponse(newsOptional.get());
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

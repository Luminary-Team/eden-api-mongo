package com.luminary.apiedenmongo.Controllers;

import com.luminary.apiedenmongo.Models.News;
import com.luminary.apiedenmongo.Services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> getAllNews() {
        return ResponseEntity.ok().body(newsService.getAllNews());
    }

    @GetMapping("{newsId}")
    public ResponseEntity<News> getNewsById(String newsId) {
        return ResponseEntity.ok().body(newsService.getNewsById(newsId));
    }

    @PostMapping
    public ResponseEntity<News> createNews(News news) {
        return ResponseEntity.ok().body(newsService.createNews(news));
    }

    @PutMapping("{newsId}")
    public ResponseEntity<News> updateNews(News news) {
        return ResponseEntity.ok().body(newsService.updateNews(news));
    }

    @DeleteMapping("{newsId}")
    public ResponseEntity<Void> deleteNews(String newsId) {
        newsService.deleteNews(newsId);
        return ResponseEntity.ok().build();
    }
}

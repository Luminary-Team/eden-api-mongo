package com.luminary.apiedenmongo.Controllers;

import com.luminary.apiedenmongo.Models.News;
import com.luminary.apiedenmongo.Services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> getAllNews() {
        return ResponseEntity.ok().body(newsService.getAllNews());
    }
}

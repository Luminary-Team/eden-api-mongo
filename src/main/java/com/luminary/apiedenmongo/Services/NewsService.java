package com.luminary.apiedenmongo.Services;

import com.luminary.apiedenmongo.Models.Database.News;
import com.luminary.apiedenmongo.Models.Request.NewsRequest;
import com.luminary.apiedenmongo.Models.Response.NewsResponse;
import com.luminary.apiedenmongo.Repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsService {
    private final NewsRepository newsRepository;

    public List<NewsResponse> getAllNews() {
        log.info("[NEWS] Fetching all news");
        return newsRepository.findAll().stream()
                .map(NewsResponse::new)
                .toList();
    }

    public NewsResponse createNews(NewsRequest newsRequest) {
        log.info("[NEWS] Creating news: " + newsRequest);

        News news = new News();

        news.setUrl(newsRequest.getUrl());
        news.setTitle(newsRequest.getTitle());
        news.setDescription(newsRequest.getDescription());

        log.info("[NEWS] Persisting news in database");
        News savedNews = newsRepository.save(news);
        log.info("[NEWS] News created successfully: " + savedNews);

        return new NewsResponse(savedNews);
    }
}

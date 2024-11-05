package com.luminary.apiedenmongo.Services;

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
}

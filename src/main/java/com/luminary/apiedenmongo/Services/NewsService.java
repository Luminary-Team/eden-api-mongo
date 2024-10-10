package com.luminary.apiedenmongo.Services;

import com.luminary.apiedenmongo.Repositories.NewsRepository;
import com.luminary.apiedenmongo.Models.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NewsService {
    private final NewsRepository newsRepository;
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}

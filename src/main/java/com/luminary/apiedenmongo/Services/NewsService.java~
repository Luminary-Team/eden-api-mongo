package com.luminary.apidemongo.Services;

import com.luminary.apidemongo.Repositories.NewsRepository;
import com.luminary.apidemongo.Models.News;
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

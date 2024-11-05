package com.luminary.apiedenmongo.Models.Response;

import com.luminary.apiedenmongo.Models.Database.News;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
public class NewsResponse {
    private String id;
    private String url;
    private String title;
    private String description;
    private LocalDateTime date;
    private List<Integer> engager;

    public NewsResponse(News news) {
        this.id = news.getId().toHexString();
        this.url = news.getUrl();
        this.title = news.getTitle();
        this.description = news.getDescription();
        this.engager = news.getEngager();
    }
}

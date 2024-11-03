package com.luminary.apiedenmongo.Models.Response;

import com.luminary.apiedenmongo.Models.Database.News;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
public class NewsResponse {
    private Integer id;
    private String url;
    private String title;
    private String description;
    private LocalDateTime date;

    public NewsResponse(News news) {
        this.id = news.getId();
        this.url = news.getUrl();
        this.title = news.getTitle();
        this.description = news.getDescription();
        this.date = news.getDate();
    }
}

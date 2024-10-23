package com.luminary.apiedenmongo.Models.Response;

import com.luminary.apiedenmongo.Models.Database.News;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NewsResponse {
    private String id;
    private String url;
    private String title;
    private String description;
    private String date;

    public NewsResponse(News news) {
        this.id = news.getId().toHexString();
        this.url = news.getUrl();
        this.title = news.getTitle();
        this.description = news.getDescription();
        this.date = news.getDate();
    }
}

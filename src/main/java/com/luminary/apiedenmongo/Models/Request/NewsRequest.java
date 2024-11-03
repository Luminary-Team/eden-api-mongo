package com.luminary.apiedenmongo.Models.Request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class NewsRequest {

    private String url;
    private String title;
    private String description;

    public NewsRequest(String url, String title, String description) {
        this.url = url;
        this.title = title;
        this.description = description;
    }
}

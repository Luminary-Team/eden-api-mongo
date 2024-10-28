package com.luminary.apiedenmongo.Models.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsRequest {

    private String url;
    private String title;
    private String description;
    private String date;

    public NewsRequest(String url, String title, String description, String date) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.date = date;
    }
}

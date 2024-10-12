package com.luminary.apiedenmongo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NewsDto {

    private String url;
    private String title;
    private String description;
    private String date;

    public NewsDto(String url, String title, String description, String date) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.date = date;
    }
}

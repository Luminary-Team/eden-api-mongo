package com.luminary.apiedenmongo.Models.Requests;

import lombok.Getter;

@Getter
public class NewsRequest {

    private String url;
    private String title;
    private String description;
    private String date;

}

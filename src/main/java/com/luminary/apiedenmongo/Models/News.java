package com.luminary.apidemongo.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@ToString
@Document(collection = "news")
public class News {

    @Field(name = "_id")
    private String id;

    @Field(name = "url")
    private int url;

    @Field(name = "title")
    private int title;

    @Field(name = "description")
    private String description;

    @Field(name = "date")
    private String date;


    public News(int url, int title, String description, String date) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.date = date;
    }
}

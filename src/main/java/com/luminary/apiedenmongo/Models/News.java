package com.luminary.apiedenmongo.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@ToString
@Document(collection = "News")
public class News {

    @Id
    @Field(name = "_id")
    private String id;

    @Field(name = "url")
    private String url;

    @Field(name = "title")
    private String title;

    @Field(name = "description")
    private String description;

    @Field(name = "date")
    private String date;


    public News(String url, String title, String description, String date) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.date = date;
    }
}

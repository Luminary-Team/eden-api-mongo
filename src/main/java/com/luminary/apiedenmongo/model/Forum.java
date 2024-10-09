package com.luminary.apiedenmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Forum {
    @Id
    @Field(name = "user_id")
    private long userId;

    @Field(name = "content")
    private String content; // No modelo tá como ID

    @Field(name = "comments")
    private Comment comment;

    @Field(name = "like_id")
    private long likeId;
}

package com.luminary.apidemongo.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "Forum")
public class Forum {

    @Id
    @Field(name = "_id")
    private String id;

    @Field(name = "user_id")
    private long userId;

    @Field(name = "content")
    private int content;

    @Field(name = "comments")
    private List<Comment> comments;

    @Field(name = "like_id")
    private List<Long> likeId;


    @Getter
    @Setter
    @ToString
    public static class Comment{
        private int userId;
        private int content;
    }
}

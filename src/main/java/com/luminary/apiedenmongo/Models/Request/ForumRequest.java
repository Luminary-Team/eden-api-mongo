package com.luminary.apiedenmongo.Models.Request;

import com.luminary.apiedenmongo.Models.Database.Forum;

public class CommentRequest {
    private int userId;
    private String content;

    public CommentRequest(Forum.Comment comment) {
        this.userId = comment.getUserId();
        this.content = comment.getContent();
    }
}

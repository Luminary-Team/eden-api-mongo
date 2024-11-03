package com.luminary.apiedenmongo.Models.Response;

import com.luminary.apiedenmongo.Models.Database.Forum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ForumResponse {
    private Integer id;
    private int userId;
    private String content;
    private List<Forum.Comment> comments;
    private LocalDateTime postDate;

    public ForumResponse(Forum forum) {
        this.id = forum.getId();
        this.userId = forum.getUserId();
        this.content = forum.getContent();
        this.comments = forum.getComments();
        this.postDate = forum.getPostDate();
    }
}

package com.luminary.apiedenmongo.Models.Response;

import com.luminary.apiedenmongo.Models.Database.Forum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ForumResponse {
    private String id;
    private int userId;
    private String content;
    private LocalDateTime postDate;
    private List<Forum.Comment> comments;
    private List<Integer> engager;

    public ForumResponse(Forum forum) {
        this.id = forum.getId().toHexString();
        this.userId = forum.getUserId();
        this.content = forum.getContent();
        this.postDate = forum.getPostDate();
        this.comments = forum.getComments();
        this.engager = forum.getEngager();
    }
}

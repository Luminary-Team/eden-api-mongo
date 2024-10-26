package com.luminary.apiedenmongo.Models.Response;

import com.luminary.apiedenmongo.Models.Database.Forum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ForumResponse {
    private String id;
    private int userId;
    private String content;
    private List<Forum.Comment> comments;
    private List<Long> likeId;

    public ForumResponse(Forum forum) {
        this.id = forum.getId().toHexString();
        this.userId = forum.getUserId();
        this.content = forum.getContent();
        this.comments = forum.getComments();
        this.likeId = forum.getLikeId();
    }
}

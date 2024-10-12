package com.luminary.apiedenmongo.dto;

import com.luminary.apiedenmongo.Models.Forum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ForumDto {

    private int userId;
    private int content;
    private List<Forum.Comment> comments;
    private List<Long> likeId;

    public ForumDto(int userId, int content, List<Forum.Comment> comments, List<Long> likeId) {
        this.userId = userId;
        this.content = content;
        this.comments = comments;
        this.likeId = likeId;
    }
}

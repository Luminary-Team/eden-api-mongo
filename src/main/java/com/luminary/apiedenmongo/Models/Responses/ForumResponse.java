package com.luminary.apiedenmongo.Models.Responses;

import lombok.Getter;
import com.luminary.apiedenmongo.Models.Database.Forum;

import java.util.List;

@Getter
public class ForumResponse {
    int userId;
    String content;
    List<Forum.Comment> comments;
    List<Long> likeId;

}

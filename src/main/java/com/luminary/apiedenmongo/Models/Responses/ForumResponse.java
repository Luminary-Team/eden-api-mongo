package com.luminary.apiedenmongo.Models.Responses;

import lombok.Getter;
import com.luminary.apiedenmongo.Models.Collections.Forum;

import java.util.List;

@Getter
public class ForumResponse {
    int userId;
    int content;
    List<Forum.Comment> comments;
    List<Long> likeId;

}

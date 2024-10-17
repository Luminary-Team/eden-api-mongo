package com.luminary.apiedenmongo.Models.Requests;

import com.luminary.apiedenmongo.Models.Database.Forum;
import lombok.Getter;

import java.util.List;

@Getter
public class ForumRequest {

    private int userId;
    private int content;
    private List<Forum.Comment> comments;
    private List<Long> likeId;

}

package com.luminary.apiedenmongo.dto;

import com.luminary.apiedenmongo.Models.Forum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
public class ForumDto {

    private int userId;
    private int content;
    private List<Forum.Comment> comments;
    private List<Long> likeId;

}

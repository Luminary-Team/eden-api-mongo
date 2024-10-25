package com.luminary.apiedenmongo.Models.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForumRequest {

    @Schema(description = "User ID of the forum creator.", example = "12345")
    private int userId;

    @Schema(description = "Forum content.", example = "This is the forum content")
    private String content;

    public ForumRequest(int userId, String content) {
        this.userId = userId;
        this.content = content;
    }
}

package com.luminary.apiedenmongo.Models.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForumRequest {

    @Schema(description = "User ID of the forum creator.", example = "12345")
    @NotNull(message = "user_id cannot be null")
    @NotEmpty(message = "user_id cannot be empty")
    private int userId;

    @Schema(description = "Forum content.", example = "This is the forum content")
    @NotNull(message = "content cannot be null")
    @NotEmpty(message = "content cannot be empty")
    private String content;

    public ForumRequest(int userId, String content) {
        this.userId = userId;
        this.content = content;
    }
}

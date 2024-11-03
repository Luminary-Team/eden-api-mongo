package com.luminary.apiedenmongo.Models.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ForumRequest {

    @Schema(description = "User ID of the forum creator.", example = "12345")
    @NotNull(message = "user_id cannot be null")
    private int userId;

    @Schema(description = "Forum content.", example = "This is the forum content")
    @NotNull(message = "content cannot be null")
    private String content;

    public ForumRequest(int userId, String content) {
        this.userId = userId;
        this.content = content;
    }
}

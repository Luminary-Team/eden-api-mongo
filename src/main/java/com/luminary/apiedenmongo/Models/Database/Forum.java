package com.luminary.apiedenmongo.Models.Database;

import io.swagger.v3.oas.annotations.media.Schema; // Swagger/OpenAPI annotation
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "Forum")
@Schema(description = "Representation of a forum with content, comments and likes.")
public class Forum {

    @Id
    @Field(name = "_id")
    @Schema(description = "Forum ID.")
    private String id;

    @Field(name = "user_id")
    @NotNull(message = "user_id cannot be null")
    @Schema(description = "User ID of the forum creator.", example = "12345")
    private int userId;

    @Field(name = "content")
    @NotNull(message = "content cannot be null")
    @Schema(description = "Forum content.", example = "This is the forum content")
    private String content;

    @Field(name = "comments")
    @Schema(description = "List of comments associated with the forum.")
    private List<Comment> comments;

    @Field(name = "like_id")
    @Schema(description = "List of user IDs that liked the forum.", example = "[123, 456, 789]")
    private List<Long> likeId;

    @Getter
    @Setter
    @ToString
    @Schema(description = "Comment made by a user in the forum.")
    public static class Comment {
        @Schema(description = "User ID of the comment.", example = "123")
        @NotNull(message = "user_id cannot be null")
        private int userId;

        @Schema(description = "Content of the comment.", example = "This is a content.")
        private String content;
    }
}

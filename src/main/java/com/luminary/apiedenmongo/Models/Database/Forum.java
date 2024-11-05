package com.luminary.apiedenmongo.Models.Database;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "Forum")
@Schema(description = "Representation of a forum with content, comments and likes.")
public class Forum {

    @Id
    @Field(name = "_id")
    private ObjectId id;

    @Field(name = "post_id")
    @NotNull(message = "postId cannot be null")
    private int postId;

    @Field(name = "user_id")
    @NotNull(message = "user_id cannot be null")
    @Schema(description = "User ID of the forum creator.", example = "12345")
    private int userId;

    @Field(name = "content")
    @NotNull(message = "content cannot be null")
    @Schema(description = "Forum content.", example = "This is the forum content")
    private String content;

    @Field(name = "comments")
    private List<Comment> comments;

    @Field(name = "post_date")
    private LocalDateTime postDate;

    @Getter
    @Setter
    @ToString
    @Schema(description = "Comment made by a user in the forum.")
    public static class Comment {
        @Schema(description = "User ID of the comment.", example = "123")
        @NotNull(message = "user_id cannot be null")
        private int userId;

        @Schema(description = "Content of the comment.", example = "This is a content.")
        @NotNull(message = "content cannot be null")
        private String content;

        private LocalDateTime postDate;
    }
}

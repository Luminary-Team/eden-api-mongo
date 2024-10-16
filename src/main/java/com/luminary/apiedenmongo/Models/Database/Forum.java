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
@Schema(description = "Representação de um fórum com conteúdo, comentários e likes.")
public class Forum {

    @Id
    @Field(name = "_id")
    @Schema(description = "Identificador único do fórum.")
    private String id;

    @Field(name = "user_id")
    @NotNull(message = "user_id cannot be null")
    @Schema(description = "ID do usuário que criou o fórum.", example = "12345")
    private int userId;

    @Field(name = "content")
    @NotNull(message = "content cannot be null")
    @Schema(description = "Conteúdo do fórum.", example = "Este é o conteúdo do fórum")
    private int content;

    @Field(name = "comments")
    @Schema(description = "Lista de comentários associados ao fórum.", example = "[{user_id: 123, content: 'Comentário 1'}, {user_id: 456, content: 'Comentário 2'}]")
    private List<Comment> comments;

    @Field(name = "like_id")
    @Schema(description = "Lista de IDs de usuários que curtiram o fórum.", example = "[123, 456, 789]")
    private List<Long> likeId;

    @Getter
    @Setter
    @ToString
    @Schema(description = "Comentário feito por um usuário no fórum.")
    public static class Comment {
        @Schema(description = "ID do usuário que fez o comentário.", example = "123")
        @NotNull(message = "user_id cannot be null")
        private int userId;

        @Schema(description = "Conteúdo do comentário.", example = "Este é um comentário.")
        private int content;
    }
}

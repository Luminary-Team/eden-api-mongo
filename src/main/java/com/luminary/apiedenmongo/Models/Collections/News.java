package com.luminary.apiedenmongo.Models.Collections;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@ToString
@Document(collection = "News")
@Schema(description = "Representação de uma noticia.")
public class News {

    @Id
    @Field(name = "_id")
    @Schema(description = "Identificador único da noticia.", example = "12345")
    private String id;

    @Field(name = "url")
    @NotNull(message = "url cannot be null")
    @Pattern(regexp = "https?://.*", message = "url must be a valid URL")
    @Schema(description = "URL da noticia.", example = "https://example.com/news")
    private String url;

    @Field(name = "title")
    @NotNull(message = "title cannot be null")
    @Size(min = 5, max = 100, message = "title must be between 5 and 100 characters")
    @Schema(description = "Título da noticia.", example = "Noticia exemplo")
    private String title;

    @Field(name = "description")
    @NotNull(message = "description cannot be null")
    @Size(min = 10, message = "description must have at least 10 characters")
    @Schema(description = "Descrição da noticia.", example = "Esta é a descrição da noticia")
    private String description;

    @Field(name = "date")
    @NotNull(message = "date cannot be null")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "date must follow the format YYYY-MM-DD")
    @Schema(description = "Data da noticia.", example = "2024-10-16")
    private String date;

    public News(String url, String title, String description, String date) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.date = date;
    }
}
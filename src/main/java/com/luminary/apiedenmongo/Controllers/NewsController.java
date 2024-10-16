package com.luminary.apiedenmongo.Controllers;

import com.luminary.apiedenmongo.Models.Database.News;
import com.luminary.apiedenmongo.Services.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
@Tag(name = "News", description = "API para manipular notícias")
public class NewsController {

    private final NewsService newsService;


    @Operation(summary = "Obter todas as notícias", description = "Retorna uma lista de todas as notícias.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de notícias retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @Operation(summary = "Obter notícia por ID", description = "Retorna uma notícia específica pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notícia retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Notícia não encontrada")
    })
    @GetMapping("/{id}")
    public News getNewsById(@PathVariable String id) {
        return newsService.getNewsById(id)
                .orElseThrow(() -> new RuntimeException("Forum não encontrado"));
    }
}

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
@Tag(name = "News", description = "Operations related to news")
public class NewsController {

    private final NewsService newsService;


    @Operation(summary = "Get all the news" +
            "", description = "Returns a list of all news.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "News list successfully returned"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @Operation(summary = "Get news by ID", description = "Returns a specific news by your ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "News successfully returned"),
            @ApiResponse(responseCode = "404", description = "News not found")
    })
    @GetMapping("/{id}")
    public News getNewsById(@PathVariable String id) {
        return newsService.getNewsById(id)
                .orElseThrow(() -> new RuntimeException("News not found"));
    }
}

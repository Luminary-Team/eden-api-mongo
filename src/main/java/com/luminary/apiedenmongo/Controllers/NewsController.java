package com.luminary.apiedenmongo.Controllers;

import com.luminary.apiedenmongo.Models.Request.NewsRequest;
import com.luminary.apiedenmongo.Models.Response.NewsResponse;
import com.luminary.apiedenmongo.Services.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
@Tag(name = "News", description = "Operations related to news")
public class NewsController {

    private final NewsService newsService;

    @Operation(summary = "Get all the news", description = "Returns a list of all news.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "News list successfully returned"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<NewsResponse>> getAllNews() {
        return ResponseEntity.status(HttpStatus.OK).body(newsService.getAllNews());
    }


    @Operation(summary = "Create news", description = "Create a new news.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "News created successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<NewsResponse> createNews(@RequestBody NewsRequest news) {
        return ResponseEntity.status(HttpStatus.CREATED).body(newsService.createNews(news));
    }
}

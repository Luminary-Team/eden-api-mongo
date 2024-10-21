package com.luminary.apiedenmongo.Controllers;

import com.luminary.apiedenmongo.Models.Database.Forum;
import com.luminary.apiedenmongo.Services.ForumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum")
@RequiredArgsConstructor
@Tag(name = "Forum", description = "Operations related to forums.")
public class ForumController {

    private final ForumService forumService;

    @Operation(summary = "Get all the forums", description = "Returns a list of all forums.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned list of forums"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Forum> getAllForums() {
        return forumService.getAllForums();
    }

    @Operation(summary = "Get forum by ID", description = "Returns a specific forum by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Forum successfully returned"),
            @ApiResponse(responseCode = "404", description = "Forum not found")
    })
    @GetMapping("/{id}")
    public Forum getForumById(@PathVariable String id) {
        return forumService.getForumById(id)
                .orElseThrow(() -> new RuntimeException("Fórum not found"));
    }

    @Operation(summary = "Create forum", description = "Create a new forum.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Forum created successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public Forum createForum(@RequestBody Forum forum) {
        return forumService.createForum(forum);
    }
}

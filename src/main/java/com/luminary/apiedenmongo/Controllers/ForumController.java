package com.luminary.apiedenmongo.Controllers;

import com.luminary.apiedenmongo.Models.Database.Forum;
import com.luminary.apiedenmongo.Models.Request.ForumRequest;
import com.luminary.apiedenmongo.Models.Request.LikeRequest;
import com.luminary.apiedenmongo.Models.Response.ForumResponse;
import com.luminary.apiedenmongo.Services.ForumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ForumResponse>> getAllForums() {
        return ResponseEntity.status(HttpStatus.OK).body(forumService.getAllForums());
    }

    @Operation(summary = "Get forum by ID", description = "Returns a specific forum by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Forum successfully returned"),
            @ApiResponse(responseCode = "404", description = "Forum not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ForumResponse> getForumById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(forumService.getForumById(id));
    }

    @Operation(summary = "Get forum by userId", description = "Returns a list of forums by an userId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Forum list returned successfully"),
            @ApiResponse(responseCode = "400", description = "User doesn't have any post"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ForumResponse>> getForumByUserId(@PathVariable("userId") String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(forumService.getForumByUserId(userId));
    }

    @Operation(summary = "Create forum", description = "Create a new forum.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Forum created successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<ForumResponse> createForum(@RequestBody ForumRequest forum) {
        return ResponseEntity.status(HttpStatus.CREATED).body(forumService.createForum(forum));
    }

    @Operation(summary = "Add comment to forum", description = "Add a new comment to a forum.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment added successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/comment/{forumId}")
    public ResponseEntity<ForumResponse> addComment(@PathVariable("forumId") String forumId, @RequestBody Forum.Comment comment) {
        return ResponseEntity.status(HttpStatus.OK).body(forumService.addComment(forumId, comment));
    }

    @Operation(summary = "Add like to forum", description = "Add a new like to a forum.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Like added successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/like/{forumId}")
    private ResponseEntity<ForumResponse> addLike(String forumId, LikeRequest engagerId) {
        return ResponseEntity.status(HttpStatus.OK).body(forumService.addLike(forumId, engagerId));
    }
}

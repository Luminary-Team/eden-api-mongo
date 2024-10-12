package com.luminary.apiedenmongo.Controllers;

import com.luminary.apiedenmongo.Models.Forum;
import com.luminary.apiedenmongo.Services.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum")
@RequiredArgsConstructor
public class ForumController {

    private final ForumService forumService;

    @GetMapping()
    public ResponseEntity<List<Forum>> getAllForum() {
        return ResponseEntity.ok().body(forumService.getAllForum());
    }

    @GetMapping("{forumId}")
    public ResponseEntity<Forum> getForumById(String forumId) {
        return ResponseEntity.ok().body(forumService.getForumById(forumId));
    }

    @PostMapping()
    public ResponseEntity<Forum> createForum(Forum forum) {
        return ResponseEntity.ok().body(forumService.createForum(forum));
    }

    @PutMapping("{forumId}")
    public ResponseEntity<Forum> updateForum(Forum forum) {
        return ResponseEntity.ok().body(forumService.updateForum(forum));
    }

    @DeleteMapping("{forumId}")
    public void deleteForum(String forumId) {
        forumService.deleteForum(forumId);
    }
}

package com.luminary.apiedenmongo.Controllers;

import com.luminary.apiedenmongo.Models.Forum;
import com.luminary.apiedenmongo.Services.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

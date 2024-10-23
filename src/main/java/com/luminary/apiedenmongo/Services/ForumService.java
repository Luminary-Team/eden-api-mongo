package com.luminary.apiedenmongo.Services;

import com.luminary.apiedenmongo.Models.Database.Forum;
import com.luminary.apiedenmongo.Models.Response.ForumResponse;
import com.luminary.apiedenmongo.Repositories.ForumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ForumService {
    private final ForumRepository forumRepository;

    public List<Forum> getAllForums() {
        log.info("[FORUM] Fetching all forums");
        return forumRepository.findAll();
    }

    public ResponseEntity<ForumResponse> getForumById(String id) {
        log.info("[FORUM] Fetching forum by ID: " + id);
        if (ObjectId.isValid(id)) {
            log.info("[FORUM] Valid ObjectId: " + id);
            Optional<Forum> forumOptional = forumRepository.findById(new ObjectId(id));
            if (forumOptional.isPresent()) {
                ForumResponse response = new ForumResponse(forumOptional.get());
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<Forum> createForum(Forum forum) {
        log.info("[FORUM] Creating forum: " + forum);
        try {
            Forum savedForum = forumRepository.save(forum);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedForum);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

package com.luminary.apiedenmongo.Services;

import com.luminary.apiedenmongo.Models.Database.Forum;
import com.luminary.apiedenmongo.Models.Request.ForumRequest;
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

    public List<ForumResponse> getAllForums() {
        log.info("[FORUM] Fetching all forums");
        return forumRepository.findAll().stream()
                .map(ForumResponse::new)
                .toList();
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

    public ResponseEntity<ForumResponse> createForum(ForumRequest forumRequest) {
        log.info("[FORUM] Creating forum: " + forumRequest);
        try {
            Forum forum = new Forum();
            forum.setUserId(forumRequest.getUserId());
            forum.setContent(forumRequest.getContent());
            Forum savedForum = forumRepository.save(forum);

            ForumResponse response = new ForumResponse(savedForum);
            log.info("[FORUM] Forum created successfully: " + savedForum);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<ForumResponse> addComment(String forumId, Forum.Comment comment) {
        log.info("[FORUM] Adding comment to forum ID: " + forumId);
        Optional<Forum> forumOptional = forumRepository.findById(new ObjectId(forumId));

        if (forumOptional.isPresent()) {
            Forum forum = forumOptional.get();
            forum.getComments().add(comment);
            Forum updatedForum = forumRepository.save(forum);
            ForumResponse response = new ForumResponse(updatedForum);

            log.info("[FORUM] Comment added successfully: " + comment);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

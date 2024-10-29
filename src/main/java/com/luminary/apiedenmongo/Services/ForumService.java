package com.luminary.apiedenmongo.Services;

import com.luminary.apiedenmongo.Models.Database.Forum;
import com.luminary.apiedenmongo.Models.Request.ForumRequest;
import com.luminary.apiedenmongo.Models.Request.LikeRequest;
import com.luminary.apiedenmongo.Models.Response.ForumResponse;
import com.luminary.apiedenmongo.Repositories.ForumRepository;
import com.luminary.apiedenmongo.Models.Exception.HttpError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ForumService {
    private final ForumRepository forumRepository;

    public List<ForumResponse> getAllForums() {
        log.info("[FORUM] Fetching all forums");
        return forumRepository.findAll().stream()
                .map(ForumResponse::new)
                .toList();
    }

    public ForumResponse getForumById(String id) {
        log.info("[FORUM] Fetching forum by ID: " + id);
        if (id.length() != 24) {
            throw new HttpError(HttpStatus.BAD_REQUEST, "ID com tamanho inválido");
        }        Forum forum = forumRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new HttpError(HttpStatus.BAD_REQUEST, "Fórum não encontrado"));
        log.info("[FORUM] Forum found with ID: " + id);
        return new ForumResponse(forum);
    }

    public ForumResponse createForum(ForumRequest forumRequest) {
        log.info("[FORUM] Creating forum: " + forumRequest);

        Forum forum = new Forum();
        forum.setUserId(forumRequest.getUserId());
        forum.setContent(forumRequest.getContent());
        forum.setComments(new ArrayList<>());
        forum.setLikeId(new ArrayList<>());

        log.info("[FORUM] Persisting forum in database");
        Forum savedForum = forumRepository.save(forum);
        log.info("[FORUM] Forum created successfully: " + savedForum);

        return new ForumResponse(savedForum);
    }

    public ForumResponse addComment(String forumId, Forum.Comment comment) {
        log.info("[FORUM] Adding comment to forum ID: " + forumId);
        Forum forum = forumRepository.findById(new ObjectId(forumId))
                .orElseThrow(() -> new HttpError(HttpStatus.BAD_REQUEST, "Fórum não encontrado"));

        if (forum.getComments() == null) {
            forum.setComments(new ArrayList<>());
        }

        forum.getComments().add(comment);
        log.info("[FORUM] Persisting updated forum in database");
        Forum updatedForum = forumRepository.save(forum);
        log.info("[FORUM] Comment added successfully to forum ID: " + forumId);

        return new ForumResponse(updatedForum);
    }

    public ForumResponse addLike(String forumId, LikeRequest likeRequest) {
        log.info("[FORUM] Adding like to forum ID: " + forumId);
        Forum forum = forumRepository.findById(new ObjectId(forumId))
                .orElseThrow(() -> new HttpError(HttpStatus.BAD_REQUEST, "Fórum não encontrado"));

        if (forum.getLikeId() != null && forum.getLikeId().contains(likeRequest.getUserId())) {
            log.info("[FORUM] Like already exists for user ID: " + likeRequest.getUserId());
            return new ForumResponse(forum);
        }

        if (forum.getLikeId() == null) {
            forum.setLikeId(new ArrayList<>());
        }

        forum.getLikeId().add(likeRequest.getUserId());
        log.info("[FORUM] Persisting updated forum in database");
        Forum updatedForum = forumRepository.save(forum);
        log.info("[FORUM] Like added successfully to forum ID: " + forumId);

        return new ForumResponse(updatedForum);
    }
}

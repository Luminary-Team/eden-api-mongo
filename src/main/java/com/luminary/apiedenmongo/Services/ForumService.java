package com.luminary.apiedenmongo.Services;

import com.luminary.apiedenmongo.Models.Database.Forum;
import com.luminary.apiedenmongo.Models.Request.ForumRequest;
import com.luminary.apiedenmongo.Models.Response.ForumResponse;
import com.luminary.apiedenmongo.Repositories.ForumRepository;
import com.luminary.apiedenmongo.Models.Exception.HttpError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        Forum forum = forumRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new HttpError(HttpStatus.BAD_REQUEST, "Fórum não encontrado"));
        log.info("[FORUM] Forum found with ID: " + id);
        return new ForumResponse(forum);
    }

    public List<ForumResponse> getForumByUserId(String userId) {
        log.info("[FORUM Fetching forum by userId: {}", userId);
        List<Forum> forumList = forumRepository.findByUserId(Integer.parseInt(userId));
        if (forumList.isEmpty()) {
            throw new HttpError(HttpStatus.BAD_REQUEST, "Usuário não criou nenhum post.");
        }
        return forumList.stream()
                .map(ForumResponse::new)
                .toList();
    }

    public ForumResponse createForum(ForumRequest forumRequest) {
        log.info("[FORUM] Creating forum: " + forumRequest);

        Forum last = forumRepository.findTop1ByOrderByPostDateDesc();
        int newPostId = (last == null) ? 1 : last.getPostId() + 1;

        Forum forum = new Forum();
        forum.setPostId(newPostId);
        forum.setUserId(forumRequest.getUserId());
        forum.setContent(forumRequest.getContent());
        forum.setComments(new ArrayList<>());
        forum.setPostDate(LocalDateTime.now());

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

        comment.setPostDate(LocalDateTime.now());
        forum.getComments().add(comment);
        log.info("[FORUM] Persisting updated forum in database");
        Forum updatedForum = forumRepository.save(forum);
        log.info("[FORUM] Comment added successfully to forum ID: " + forumId);

        return new ForumResponse(updatedForum);
    }
}

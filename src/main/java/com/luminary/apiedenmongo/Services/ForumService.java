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

    public ForumResponse createForum(ForumRequest forumRequest) {
        log.info("[FORUM] Creating forum: " + forumRequest);

        Forum forum = new Forum();
        forum.setUserId(forumRequest.getUserId());
        forum.setContent(forumRequest.getContent());

        log.info("[FORUM] Persisting forum in database");
        Forum savedForum = forumRepository.save(forum);
        log.info("[FORUM] Forum created successfully: " + savedForum);

        return new ForumResponse(savedForum);
    }

}

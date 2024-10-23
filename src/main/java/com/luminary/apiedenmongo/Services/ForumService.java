package com.luminary.apiedenmongo.Services;

import com.luminary.apiedenmongo.Repositories.ForumRepository;
import com.luminary.apiedenmongo.Models.Database.Forum;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

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

    public Optional<Forum> getForumById(String id) {
        log.info("[FORUM] Fetching forum by ID: " + id);
        if (ObjectId.isValid(id)) {
            log.info("[FORUM] Valid ObjectId: " + id);
            return forumRepository.findById(new ObjectId(id));
        } else {
            log.warn("[FORUM] Invalid ObjectId: " + id);
            return Optional.empty();
        }
    }

    public Forum createForum(Forum forum) {
        log.info("[FORUM] Creating forum: " + forum);
        return forumRepository.save(forum);
    }
}

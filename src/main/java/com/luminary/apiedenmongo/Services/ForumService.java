package com.luminary.apiedenmongo.Services;

import com.luminary.apiedenmongo.Models.Responses.ForumResponse;
import com.luminary.apiedenmongo.Repositories.ForumRepository;
import com.luminary.apiedenmongo.Models.Collections.Forum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        return forumRepository.findById(id);
    }
}

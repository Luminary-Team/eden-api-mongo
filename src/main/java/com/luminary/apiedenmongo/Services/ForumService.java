package com.luminary.apiedenmongo.Services;

import com.luminary.apiedenmongo.Repositories.ForumRepository;
import com.luminary.apiedenmongo.Models.Forum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ForumService {
    private final ForumRepository forumRepository;

    public List<Forum> getAllForum() {
        return forumRepository.findAll();
    }

    public Forum getForumById(String id) {
        return forumRepository.findById(id).orElse(null);
    }

    public Forum createForum(Forum forum) {
        return forumRepository.save(forum);
    }

    public Forum updateForum(Forum forum) {
        return forumRepository.save(forum);
    }

    public void deleteForum(String id) {
        forumRepository.deleteById(id);
    }
}

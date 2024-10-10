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
}

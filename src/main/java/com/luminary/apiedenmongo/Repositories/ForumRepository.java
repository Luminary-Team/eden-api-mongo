package com.luminary.apidemongo.Repositories;

import com.luminary.apidemongo.Models.Forum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends MongoRepository<Forum, String> {
}

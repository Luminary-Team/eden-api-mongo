package com.luminary.apiedenmongo.Repositories;

import com.luminary.apiedenmongo.Models.Database.Forum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends MongoRepository<Forum, String> {
}

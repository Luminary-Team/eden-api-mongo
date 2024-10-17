package com.luminary.apiedenmongo.Repositories;

import org.springframework.stereotype.Repository;
import com.luminary.apiedenmongo.Models.Database.Forum;
import org.springframework.data.mongodb.repository.MongoRepository;
@Repository
public interface ForumRepository extends MongoRepository<Forum, String> {
}

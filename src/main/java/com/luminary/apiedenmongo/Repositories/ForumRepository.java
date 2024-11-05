package com.luminary.apiedenmongo.Repositories;

import com.luminary.apiedenmongo.Models.Database.Forum;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumRepository extends MongoRepository<Forum, ObjectId> {
    List<Forum> findByUserId(int userId);
}

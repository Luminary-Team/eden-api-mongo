package com.luminary.apiedenmongo.Repositories;

import com.luminary.apiedenmongo.Models.Database.News;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends MongoRepository<News, ObjectId> {
}

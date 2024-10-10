package com.luminary.apidemongo.Repositories;

import com.luminary.apidemongo.Models.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends MongoRepository<News, String> {
}

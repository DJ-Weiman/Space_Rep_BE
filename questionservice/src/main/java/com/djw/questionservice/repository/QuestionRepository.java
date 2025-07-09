package com.djw.questionservice.repository;

import com.djw.questionservice.domain.model.QuestionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends MongoRepository<QuestionEntity, String> {
    List<QuestionEntity> findByUserID(String userId);
}

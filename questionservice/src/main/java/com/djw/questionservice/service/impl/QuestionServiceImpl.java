package com.djw.questionservice.service.impl;

import com.djw.questionservice.domain.dto.QuestionResponse;
import com.djw.questionservice.domain.model.QuestionEntity;
import com.djw.questionservice.repository.QuestionRepository;
import com.djw.questionservice.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public QuestionResponse getAllQuestions() {
        return null;
    }

    @Override
    public List<QuestionResponse> getUserQuestions(String userId) {
        List<QuestionEntity> userQuestions = questionRepository.findByUserID(userId);

        return List.of();
    }
}

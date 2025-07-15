package com.djw.questionservice.service.impl;

import com.djw.questionservice.domain.dto.QuestionResponse;
import com.djw.questionservice.domain.model.QuestionEntity;
import com.djw.questionservice.repository.QuestionRepository;
import com.djw.questionservice.service.QuestionService;
import com.djw.questionservice.service.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final UserValidationService userValidationService;

    @Override
    public QuestionResponse getAllQuestions() {
        return null;
    }

    @Override
    public List<QuestionResponse> getUserQuestions(String userId) {
        boolean isValidUser = userValidationService.validateUser(userId);

        if(!isValidUser)
            throw new RuntimeException("Invalid User: " + userId);

        List<QuestionEntity> userQuestions = questionRepository.findByUserID(userId);

        return List.of();
    }
}

package com.djw.questionservice.service;

import com.djw.questionservice.domain.dto.QuestionRequest;
import com.djw.questionservice.domain.dto.QuestionResponse;

import java.util.List;

public interface QuestionService {
    QuestionResponse createQuestion(QuestionRequest question);
    QuestionResponse getAllQuestions();

    List<QuestionResponse> getUserQuestions(String userId);
}

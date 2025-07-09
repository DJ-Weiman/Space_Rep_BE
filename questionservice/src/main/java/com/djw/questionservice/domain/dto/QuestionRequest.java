package com.djw.questionservice.domain.dto;

import lombok.Data;

@Data
public class QuestionRequest {
    private String userId;
    private String questionText;
    private String userAnswer;
}

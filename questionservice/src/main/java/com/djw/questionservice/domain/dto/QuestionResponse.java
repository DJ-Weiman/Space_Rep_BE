package com.djw.questionservice.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class QuestionResponse {
    private UUID userId;
    private String questionText;
    private String AIGenAnswer;
    private String UserAnswer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

package com.djw.questionservice.domain.dto;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class QuestionResponse {
    private UUID userId;
    private String questionText;
    private String AIGenAnswer;
    private String UserAnswer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

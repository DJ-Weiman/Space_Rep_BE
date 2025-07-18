package com.djw.ai_service.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class QuestionEntity {
    private String id;
    private String userId;
    private String questionText;
    private String AIGenAnswer;
    private String UserAnswer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

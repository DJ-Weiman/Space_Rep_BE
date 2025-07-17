package com.djw.ai_service.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "ai_answers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AiAnswerEntity {
    @Id()
    private UUID uuid;
    private UUID questionId;
    private UUID userId;
    private String answer;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}

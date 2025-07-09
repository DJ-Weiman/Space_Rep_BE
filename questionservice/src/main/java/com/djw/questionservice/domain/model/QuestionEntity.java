package com.djw.questionservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "questions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity {
    @Id
    private String id;
    private String userId;
    private String questionText;
    private String AIGenAnswer;
    private String UserAnswer;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}

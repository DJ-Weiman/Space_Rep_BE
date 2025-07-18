package com.djw.questionservice.service.impl;

import com.djw.questionservice.domain.dto.QuestionRequest;
import com.djw.questionservice.domain.dto.QuestionResponse;
import com.djw.questionservice.domain.model.QuestionEntity;
import com.djw.questionservice.repository.QuestionRepository;
import com.djw.questionservice.service.QuestionService;
import com.djw.questionservice.service.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final UserValidationService userValidationService;
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Override
    public QuestionResponse createQuestion(QuestionRequest question) {

        if(!userValidationService.validateUser(question.getUserId()))
            throw new RuntimeException("Invalid User: " + question.getUserId());

        QuestionEntity questionEntity = QuestionEntity.builder()
                .questionText(question.getQuestionText())
                .UserAnswer(question.getUserAnswer())
                .build();

        QuestionEntity savedQ = questionRepository.save(questionEntity);

        //publish to RabbitMQ Ai processing
        try{
            rabbitTemplate.convertAndSend(exchange, routingKey, savedQ);
        }catch (Exception e){
            System.out.println("Failed to publish actvity to RabbitMQ : " + e);
        }

        return QuestionResponse.builder()
                .questionText(savedQ.getQuestionText())
                .createdAt(savedQ.getCreatedAt())
                .UserAnswer(savedQ.getUserAnswer())
                .build();
    }

    @Override
    public QuestionResponse getAllQuestions() {
        return null;
    }

    @Override
    public List<QuestionResponse> getUserQuestions(String userId) {
        boolean isValidUser = userValidationService.validateUser(userId);

        if(!isValidUser)
            throw new RuntimeException("Invalid User: " + userId);

        List<QuestionEntity> userQuestions = questionRepository.findByUserId(userId);

        return List.of();
    }
}

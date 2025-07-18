package com.djw.ai_service.service;

import com.djw.ai_service.model.QuestionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionMessageListener {

//    @Value("${rabbitmq.queue.name}")
//    private String queueName;

    @RabbitListener(queues = "questions.queue")
    public void processQuestion(QuestionEntity question){
        System.out.println("Recieved question : " + question.getId());
    }
}

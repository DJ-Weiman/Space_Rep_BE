package com.djw.questionservice.controller;

import com.djw.questionservice.domain.dto.QuestionRequest;
import com.djw.questionservice.domain.dto.QuestionResponse;
import com.djw.questionservice.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponse> getQuestions(@RequestBody QuestionRequest questionRequest){
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponse>> getUserQuestions(@RequestHeader("X-User_ID") String userId){
        return ResponseEntity.ok(questionService.getUserQuestions(userId));
    }
}

package com.djw.questionservice.service.impl;

import com.djw.questionservice.service.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
public class UserValidationServiceImpl implements UserValidationService {
    private final WebClient userServiceWebClient;

    @Override
    public Boolean validateUser(String userId) {
        try{
            return userServiceWebClient.get()
                    .uri("/api/v1/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        }catch (WebClientResponseException exception){
            if(exception.getStatusCode() == HttpStatus.NOT_FOUND)
                throw new RuntimeException("User not found: " + userId);
        }

        return false;
    }
}

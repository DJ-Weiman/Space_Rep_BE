package com.djw.userservice.service.impl;

import com.djw.userservice.domain.dto.RegisterRequest;
import com.djw.userservice.domain.dto.UserResponse;
import com.djw.userservice.model.UserEntity;
import com.djw.userservice.repository.UserRepository;
import com.djw.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserResponse getUserProfile(String userId) {
        UserEntity user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        return UserResponse.builder()
                .keycloakId(user.getKeycloakId())
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public UserResponse register(@Valid RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("Email already Exists");

        UserEntity user = UserEntity.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .keycloakId(request.getKeycloakId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();

        UserEntity savedUser = userRepository.save(user);

        return UserResponse.builder()
                .keycloakId(savedUser.getKeycloakId())
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .createdAt(savedUser.getCreatedAt())
                .updatedAt(savedUser.getUpdatedAt())
                .build();
    }

    @Override
    public Boolean existByUserId(String userId) {
        return null;
    }
}

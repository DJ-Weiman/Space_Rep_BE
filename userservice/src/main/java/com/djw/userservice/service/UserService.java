package com.djw.userservice.service;

import com.djw.userservice.domain.dto.RegisterRequest;
import com.djw.userservice.domain.dto.UserResponse;
import jakarta.validation.Valid;

public interface UserService {
    UserResponse getUserProfile(String userId);

    UserResponse register(@Valid RegisterRequest request);

    Boolean existByUserId(String userId);
}

package com.example.java_proj_21.service;

import com.example.java_proj_21.dto.UserRequest;
import com.example.java_proj_21.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse createUser(UserRequest request);

    UserResponse updateUser(Long id, UserRequest request);

    void deleteUser(Long id);
}


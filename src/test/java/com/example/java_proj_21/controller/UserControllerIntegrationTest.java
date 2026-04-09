package com.example.java_proj_21.controller;

import com.example.java_proj_21.dto.UserRequest;
import com.example.java_proj_21.dto.UserResponse;
import com.example.java_proj_21.entity.User;
import com.example.java_proj_21.repository.UserRepository;
import com.example.java_proj_21.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserControllerIntegrationTest {

    @Test
    void createUserShouldReturnCreatedUser() {
        UserRepository userRepository = mock(UserRepository.class);
        UserServiceImpl userService = new UserServiceImpl(userRepository);

        UserRequest request = new UserRequest();
        request.setName("Hoang");
        request.setEmail("hoang@example.com");

        User savedUser = new User("Hoang", "hoang@example.com");
        savedUser.setId(1L);

        when(userRepository.existsByEmail("hoang@example.com")).thenReturn(false);
        when(userRepository.save(org.mockito.ArgumentMatchers.any(User.class))).thenReturn(savedUser);

        UserResponse response = userService.createUser(request);

        assertEquals(1L, response.getId());
        assertEquals("Hoang", response.getName());
        assertEquals("hoang@example.com", response.getEmail());
    }

    @Test
    void deleteUserShouldThrowWhenNotFound() {
        UserRepository userRepository = mock(UserRepository.class);
        UserServiceImpl userService = new UserServiceImpl(userRepository);

        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> userService.deleteUser(99L));
    }
}



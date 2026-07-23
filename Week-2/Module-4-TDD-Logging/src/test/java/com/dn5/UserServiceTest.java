package com.dn5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Get User By Id - Success")
    void testGetUserById() {
        User mockUser = new User(1, "John", "john@email.com");
        when(userRepository.findById(1)).thenReturn(mockUser);

        User result = userService.getUserById(1);

        assertEquals("John", result.getName());
        assertEquals("john@email.com", result.getEmail());
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    @DisplayName("Get User By Id - Not Found")
    void testGetUserByIdNotFound() {
        when(userRepository.findById(99)).thenReturn(null);

        assertThrows(RuntimeException.class, () -> {
            userService.getUserById(99);
        });

        verify(userRepository).findById(99);
    }

    @Test
    @DisplayName("Create User - Success")
    void testCreateUser() {
        User newUser = new User(2, "Alice", "alice@email.com");
        when(userRepository.existsById(2)).thenReturn(false);

        userService.createUser(newUser);

        verify(userRepository).save(newUser);
        verify(userRepository).existsById(2);
    }

    @Test
    @DisplayName("Create User - Already Exists")
    void testCreateUserAlreadyExists() {
        User existingUser = new User(1, "John", "john@email.com");
        when(userRepository.existsById(1)).thenReturn(true);

        assertThrows(RuntimeException.class, () -> {
            userService.createUser(existingUser);
        });

        verify(userRepository, never()).save(existingUser);
    }

    @Test
    @DisplayName("Delete User - Success")
    void testDeleteUser() {
        when(userRepository.existsById(1)).thenReturn(true);

        userService.deleteUser(1);

        verify(userRepository).deleteById(1);
    }

    @Test
    @DisplayName("Delete User - Not Found")
    void testDeleteUserNotFound() {
        when(userRepository.existsById(99)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> {
            userService.deleteUser(99);
        });

        verify(userRepository, never()).deleteById(99);
    }
}

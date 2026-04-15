package org.example.oenskeskyen.Services;

import org.example.oenskeskyen.Models.User;
import org.example.oenskeskyen.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository mockRepo;
    private UserService userService;

    @BeforeEach
    void setUp() {
        mockRepo = mock(UserRepository.class);
        userService = new UserService(mockRepo);
    }

    @Test
    void login_success() throws SQLException {
        User user = new User(1, "lucas", "1234");

        when(mockRepo.getUserUsername("lucas")).thenReturn(user);

        User result = userService.login("lucas", "1234");

        assertNotNull(result);
        assertEquals("lucas", result.getUsername());
    }

    @Test
    void login_wrongPassword() throws SQLException {
        User user = new User(1, "lucas", "1234");

        when(mockRepo.getUserUsername("lucas")).thenReturn(user);

        User result = userService.login("lucas", "forkert");

        assertNull(result);
    }

    @Test
    void login_userNotFound() throws SQLException {
        when(mockRepo.getUserUsername("lucas")).thenReturn(null);

        User result = userService.login("lucas", "1234");

        assertNull(result);
    }

    @Test
    void registerUser_userAlreadyExists() throws SQLException {
        User existingUser = new User(1, "lucas", "1234");

        when(mockRepo.getUserUsername("lucas")).thenReturn(existingUser);

        userService.registerUser("lucas", "1234");

        verify(mockRepo, never()).createUser(any());
    }

    @Test
    void registerUser_success() throws SQLException {
        when(mockRepo.getUserUsername("lucas")).thenReturn(null);

        userService.registerUser("lucas", "1234");

        verify(mockRepo, times(1)).createUser(any());
    }
}
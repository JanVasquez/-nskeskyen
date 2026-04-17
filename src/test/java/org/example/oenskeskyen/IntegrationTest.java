package org.example.oenskeskyen;

import org.example.oenskeskyen.Models.User;
import org.example.oenskeskyen.Services.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {

    @Disabled
    @Test
    void registerAndLoginUser() {

        UserService userService = new UserService(new org.example.oenskeskyen.Repository.UserRepository());

        String username = "testuser_" + System.currentTimeMillis();
        String password = "1234";

        userService.registerUser(username, password);

        User user = userService.login(username, password);

        assertNotNull(user);
        assertEquals(username, user.getUsername());
    }
}
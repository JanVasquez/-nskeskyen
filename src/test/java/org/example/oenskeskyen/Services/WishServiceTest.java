package org.example.oenskeskyen.Services;

import org.example.oenskeskyen.Models.Wish;
import org.example.oenskeskyen.Repository.WishRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WishServiceTest {

    private WishRepository mockRepo;
    private WishService wishService;

    @BeforeEach
    void setUp() {
        mockRepo = mock(WishRepository.class);
        wishService = new WishService(mockRepo);
    }

    @Test
    void createWish_callsRepository() throws SQLException {
        wishService.createWish("PS5", "Konsol", "link", "icon", 1);

        verify(mockRepo, times(1)).createWish(any());
    }

    @Test
    void getWishesUser_returnsList() throws SQLException {
        List<Wish> wishes = List.of(
                new Wish(1, "PS5", "Konsol", "link", "icon", 1)
        );

        when(mockRepo.getWishByUserId(1)).thenReturn(wishes);

        List<Wish> result = wishService.getWishesUser(1);

        assertEquals(1, result.size());
        assertEquals("PS5", result.get(0).getTitle());
    }

    @Test
    void deleteWish_callsRepository() throws SQLException {
        wishService.deleteWish(1, 1);

        verify(mockRepo, times(1)).deleteWish(1, 1);
    }
}
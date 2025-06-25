package com.example.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testUserFields() {
        User user = new User("Madhu", "Madhu@example.com", 25);

        assertAll("User Fields Check",
                () -> assertEquals("Madhu", user.getName()),
                () -> assertEquals("Madhu@example.com", user.getEmail()),
                () -> assertEquals(25, user.getAge()),
                () -> assertNotNull(user.getEmail()),
                () -> assertTrue(user.getAge() >= 18)
        );
    }

    @Test
    void testValidateAgeThrowsException() {
        UserService service = new UserService();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.validateAge(16);
        });

        assertEquals("Underage", exception.getMessage());
    }
}

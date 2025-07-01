package com.nisum.jest.service;
import com.nisum.jest.service.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailSender emailSender;

    @InjectMocks
    private UserService userService;

    private User mockUser;

    @BeforeEach
    void setup() {
        mockUser = new User("1", "Khushbu", "khushbupatra@gmail.com");
    }

    @Test
    void testProcessUser_FirstCallThrowsException_SecondCallSendsEmail() {
        when(userRepository.findUserById("1"))
                .thenReturn(null)
                .thenReturn(mockUser);

            RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            userService.processUser("1");
        });
        assertEquals("User not found", thrown.getMessage());

        userService.processUser("1");

        ArgumentCaptor<String> subjectCaptor = ArgumentCaptor.forClass(String.class);
        verify(emailSender).send(eq("khushbupatra@gmail.com"), subjectCaptor.capture(), anyString());
        assertEquals("Welcome!", subjectCaptor.getValue());
    }
}

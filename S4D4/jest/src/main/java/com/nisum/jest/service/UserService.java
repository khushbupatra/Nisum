package com.nisum.jest.service;
import com.nisum.jest.service.model.User;

public class UserService {

    private final UserRepository userRepository;
    private final EmailSender emailSender;

    public UserService(UserRepository userRepository, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public void processUser(String userId) {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            handleMissingUser(userId);
            throw new RuntimeException("User not found");
        }
        emailSender.send(user.getEmail(), "Welcome!", "Hello, welcome to Nisum!");
    }

    public void handleMissingUser(String userId) {
        System.out.println("Handling missing user with ID: " + userId);
    }
}
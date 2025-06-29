package com.userservice_data.controller;
import com.userservice_data.model.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public List<User> getAllUsers() {
        return List.of(
                new User(1L, "Khushbu", "khushbu@gmail.com"),
                new User(2L, "Rishi", "rishi@yahoo.com"),
                new User(3L, "Aarav", "aarav.sharma2023@gmail.com"),
                new User(4L, "Priya", "priya.patel92@gmail.com"),
                new User(5L, "Vikram", "vikram.singh.work@yahoo.com")
        );
    }
}

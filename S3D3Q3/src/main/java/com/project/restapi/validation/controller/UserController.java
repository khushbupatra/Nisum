package com.project.restapi.validation.controller;

import com.project.restapi.validation.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok("User is valid and accepted.");
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok("User update is valid.");
    }
}

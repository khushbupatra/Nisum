package com.nisum.jest.service;
import com.nisum.jest.service.model.User;

public interface UserRepository {
    User findUserById(String id);
}

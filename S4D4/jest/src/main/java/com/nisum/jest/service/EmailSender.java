package com.nisum.jest.service;

public interface EmailSender {
    void send(String to, String subject, String body);
}
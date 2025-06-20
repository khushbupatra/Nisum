package com.nisum;

import java.util.ArrayList;
import java.util.List;

class ValidationException extends RuntimeException {
    private List<String> errors;

    public ValidationException(List<String> errors) {
        super("Validation failed with multiple errors.");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}

class User {
    String name;
    int age;
    String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}

class UserValidator {

    public static void validate(User user) {
        List<String> errors = new ArrayList<>();

        if (user.name == null || user.name.trim().isEmpty()) {
            errors.add("Name cannot be empty.");
        }

        if (user.age <= 0) {
            errors.add("Age must be greater than 0.");
        }

        if (user.email == null || !user.email.contains("@")) {
            errors.add("Email is invalid.");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}

public class Q9 {
    public static void main(String[] args) {
        User user = new User("", -5, "invalidemail");

        try {
            UserValidator.validate(user);
            System.out.println("User is valid.");
        } catch (ValidationException e) {
            System.out.println("Validation failed:");
            for (String error : e.getErrors()) {
                System.out.println("- " + error);
            }
        }
    }
}

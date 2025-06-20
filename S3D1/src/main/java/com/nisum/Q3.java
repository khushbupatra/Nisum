package com.nisum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class InvalidAgeException1 extends RuntimeException {
    public InvalidAgeException1(String message) {
        super(message);
    }
}

public class Q3 {

    public static void validateAge(int age, BufferedWriter writer) throws IOException {
        try {
            if (age <= 0) {
                throw new InvalidAgeException("Age must be greater than 0");
            }
            writer.write("Valid age: " + age);
            writer.newLine();
        } catch (InvalidAgeException e) {
            writer.write("InvalidAgeException: " + e.getMessage());
            writer.newLine();
            throw e;
        }
    }

    public static void main(String[] args) {
        int[] testAges = {25, -1, 0, 19};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("age_validation_log.txt"))) {
            for (int age : testAges) {
                try {
                    validateAge(age, writer);
                } catch (InvalidAgeException e) {
                    System.out.println("Handled in main: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Other exception: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("File handling error: " + e.getMessage());
        }
    }
}


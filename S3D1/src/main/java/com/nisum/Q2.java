package com.nisum;
    class InvalidAgeException extends RuntimeException {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    public class Q2 {

        public static void validateAge(int age) {
            try {
                if (age <= 0) {
                    throw new InvalidAgeException("Age must be greater than 0");
                }
                System.out.println("Valid age: " + age);
            } catch (InvalidAgeException e) {
                throw e;
            }
        }

        public static void main(String[] args) {
            int[] testAges = {20, -3, 0, 15};

            for (int age : testAges) {
                try {
                    validateAge(age);
                } catch (InvalidAgeException e) {
                    System.out.println("InvalidAgeException caught: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Other exception: " + e.getMessage());
                }
            }
        }
    }


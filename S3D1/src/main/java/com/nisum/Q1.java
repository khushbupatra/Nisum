package com.nisum;

public class Q1 {
    public static int divide(int num, int denom) {
        if (denom == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num / denom;
    }

    public static void main(String[] args) {
        int[] num = {3, 20, 15};
        int[] denom = {2, 0, 5};

        for (int i = 0; i < num.length; i++) {
            try {
                float result = divide(num[i], denom[i]);
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

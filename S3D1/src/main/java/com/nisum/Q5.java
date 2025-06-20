package com.nisum;

import java.io.*;

public class Q5 {

    public static void main(String[] args) {
        String filePath = "numbers5.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Integers from file:");
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                System.out.println(number);
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("An error occurred while reading or parsing the file: " + e.getMessage());
        }
    }
}

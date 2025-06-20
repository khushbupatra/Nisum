package com.nisum;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Q7 {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            try (PrintWriter writer = new PrintWriter(new FileWriter("error_log.txt", true))) {
                writer.println("Unhandled Exception in Thread: " + thread.getName());
                writer.println("Exception Message: " + throwable.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        int result = 10 / 0;
        System.out.println("Result: " + result);
    }
}


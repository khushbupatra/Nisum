package com.nisum;

public class Q21 {

    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                System.out.println("Odd: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        evenThread.start();
        oddThread.start();
    }
}


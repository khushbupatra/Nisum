package com.nisum;

class SyncCounter1 {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}

public class Q25S {
    public static void main(String[] args) throws InterruptedException {
        SyncCounter counter = new SyncCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.count);
    }
}


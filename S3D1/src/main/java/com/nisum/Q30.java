package com.nisum;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private int counter = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " incremented counter to " + counter);
        } finally {
            lock.unlock();
        }
    }
}

class MyWorker extends Thread {
    private SharedResource resource;

    public MyWorker(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.increment();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Q30 {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        MyWorker t1 = new MyWorker(resource);
        MyWorker t2 = new MyWorker(resource);

        t1.start();
        t2.start();
    }
}


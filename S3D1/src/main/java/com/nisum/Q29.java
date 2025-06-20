package com.nisum;

class SharedBuffer {
    private int data;
    private boolean isEmpty = true;

    public synchronized void produce(int value) throws InterruptedException {
        while (!isEmpty) {
            wait();
        }
        data = value;
        isEmpty = false;
        System.out.println("Produced: " + data);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (isEmpty) {
            wait();
        }
        System.out.println("Consumed: " + data);
        isEmpty = true;
        notify();
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                buffer.produce(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                buffer.consume();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Q29 {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}


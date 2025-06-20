package com.nisum;

class PrimeSumThread extends Thread {
    private int start, end;
    private long sum = 0;

    public PrimeSumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
    }

    public long getSum() {
        return sum;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

public class Q28 {
    public static void main(String[] args) throws InterruptedException {
        int limit = 100;
        int mid = limit / 2;

        PrimeSumThread t1 = new PrimeSumThread(2, mid);
        PrimeSumThread t2 = new PrimeSumThread(mid + 1, limit);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long totalSum = t1.getSum() + t2.getSum();

        System.out.println("Sum of prime numbers up to " + limit + " is: " + totalSum);
    }
}

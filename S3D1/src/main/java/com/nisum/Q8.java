package com.nisum;

import java.util.Random;

public class Q8 {

    public static void main(String[] args) {
        try {
            String result = retryNetworkCall(3);
            System.out.println("Operation Result: " + result);
        } catch (Exception e) {
            System.out.println("Operation failed after retries: " + e.getMessage());
        }
    }

    public static String retryNetworkCall(int maxRetries) throws Exception {
        int attempt = 0;

        while (attempt < maxRetries) {
            try {
                return makeFakeNetworkCall();
            } catch (Exception e) {
                attempt++;
                System.out.println("Attempt " + attempt + " failed: " + e.getMessage());

                long waitTime = (long) Math.pow(2, attempt) * 1000;
                System.out.println("Waiting for " + waitTime + " ms before retrying...");
                Thread.sleep(waitTime);
            }
        }

        throw new Exception("All retry attempts failed.");
    }

    public static String makeFakeNetworkCall() throws Exception {
        Random random = new Random();
        boolean success = random.nextBoolean();

        if (!success) {
            throw new Exception("Temporary network issue");
        }
        return "Success!";
    }
}


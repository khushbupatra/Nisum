package com.nisum;

import java.io.IOException;
import java.io.UncheckedIOException;

public class Q4 {
    public static void legacyMethod() throws IOException {
        throw new IOException("Legacy API encountered an error.");
    }

    @FunctionalInterface
    interface RunnableWithIOException {
        void run() throws IOException;
    }

    public static void runWithUncheckedIO(RunnableWithIOException action) {
        try {
            action.run();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void main(String[] args) {
        try {
            runWithUncheckedIO(() -> legacyMethod());
        } catch (UncheckedIOException e) {
            System.out.println("Caught UncheckedIOException: " + e.getMessage());
        }
    }
}


package com.nisum;

class MatrixMultiplier extends Thread {
    private int row;
    private int[][] A, B, result;

    public MatrixMultiplier(int row, int[][] A, int[][] B, int[][] result) {
        this.row = row;
        this.A = A;
        this.B = B;
        this.result = result;
    }

    public void run() {
        int colsB = B[0].length;
        int colsA = A[0].length;

        for (int j = 0; j < colsB; j++) {
            for (int k = 0; k < colsA; k++) {
                result[row][j] += A[row][k] * B[k][j];
            }
        }
    }
}

public class Q27{
    public static void main(String[] args) throws InterruptedException {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] B = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        int rowsA = A.length;
        int colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];

        Thread[] threads = new Thread[rowsA];

        for (int i = 0; i < rowsA; i++) {
            threads[i] = new MatrixMultiplier(i, A, B, result);
            threads[i].start();
        }

        for (int i = 0; i < rowsA; i++) {
            threads[i].join();
        }

        System.out.println("Result Matrix:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}


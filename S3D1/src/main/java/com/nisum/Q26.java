package com.nisum;

import java.util.Arrays;

class SortThread extends Thread {
    private int[] array;

    public SortThread(int[] array) {
        this.array = array;
    }

    public void run() {
        Arrays.sort(array);
    }

    public int[] getSortedArray() {
        return array;
    }
}

public class Q26 {
    public static void main(String[] args) throws InterruptedException {
        int[] numbers = {9, 2, 6, 3, 1, 5, 8, 4};
        int mid = numbers.length / 2;
        int[] firstHalf = Arrays.copyOfRange(numbers, 0, mid);
        int[] secondHalf = Arrays.copyOfRange(numbers, mid, numbers.length);

        SortThread thread1 = new SortThread(firstHalf);
        SortThread thread2 = new SortThread(secondHalf);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        int[] sortedArray = merge(thread1.getSortedArray(), thread2.getSortedArray());

        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }
}

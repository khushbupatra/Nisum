import java.util.Arrays;

public class Q26 {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {9, 7, 5, 3, 1, 2, 4, 6, 8, 0};

        Thread t1 = new Thread(() -> Arrays.sort(arr, 0, arr.length / 2));
        Thread t2 = new Thread(() -> Arrays.sort(arr, arr.length / 2, arr.length));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

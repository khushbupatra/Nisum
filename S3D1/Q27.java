class MatrixMultiply implements Runnable {
    int[][] a, b, c;
    int row;

    public MatrixMultiply(int[][] a, int[][] b, int[][] c, int row) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.row = row;
    }

    public void run() {
        for (int j = 0; j < b[0].length; j++) {
            c[row][j] = 0;
            for (int k = 0; k < b.length; k++) {
                c[row][j] += a[row][k] * b[k][j];
            }
        }
    }
}

public class Q27 {
    public static void main(String[] args) throws InterruptedException {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2];

        Thread[] threads = new Thread[2];
        for (int i = 0; i < 2; i++) {
            threads[i] = new Thread(new MatrixMultiply(a, b, c, i));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        for (int[] row : c) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

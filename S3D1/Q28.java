class PrimeSum implements Runnable {
    int start, end;
    int sum = 0;

    public PrimeSum(int start, int end) {
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

    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

public class Q28 {
    public static void main(String[] args) throws InterruptedException {
        PrimeSum p1 = new PrimeSum(1, 5000);
        PrimeSum p2 = new PrimeSum(5001, 10000);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(p1.sum + p2.sum);
    }
}

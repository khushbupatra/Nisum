import java.util.concurrent.locks.*;

public class Q30 {
    static int count = 0;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            lock.lock();
            try {
                for (int i = 0; i < 1000; i++) {
                    count++;
                }
            } finally {
                lock.unlock();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(count);
    }
}

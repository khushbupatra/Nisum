import java.util.concurrent.locks.*;

class Account {
    int balance;
    Lock lock = new ReentrantLock();

    public Account(int amount) {
        balance = amount;
    }

    public void transfer(Account to, int amount) {
        lock.lock();
        to.lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                to.balance += amount;
            }
        } finally {
            to.lock.unlock();
            lock.unlock();
        }
    }
}

public class Q24 {
    public static void main(String[] args) {
        Account a1 = new Account(1000);
        Account a2 = new Account(1000);

        Thread t1 = new Thread(() -> a1.transfer(a2, 100));
        Thread t2 = new Thread(() -> a2.transfer(a1, 200));

        t1.start();
        t2.start();
    }
}

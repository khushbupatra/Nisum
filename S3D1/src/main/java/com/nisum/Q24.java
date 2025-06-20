package com.nisum;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }
}

class TransferTask implements Runnable {
    private final BankAccount fromAccount;
    private final BankAccount toAccount;
    private final int amount;

    public TransferTask(BankAccount from, BankAccount to, int amount) {
        this.fromAccount = from;
        this.toAccount = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        BankAccount firstLock = fromAccount.hashCode() < toAccount.hashCode() ? fromAccount : toAccount;
        BankAccount secondLock = fromAccount.hashCode() < toAccount.hashCode() ? toAccount : fromAccount;

        try {
            if (firstLock.getLock().tryLock()) {
                try {
                    if (secondLock.getLock().tryLock()) {
                        try {
                            if (fromAccount.withdraw(amount)) {
                                toAccount.deposit(amount);
                                System.out.println(Thread.currentThread().getName() + ": Transferred " + amount);
                            } else {
                                System.out.println(Thread.currentThread().getName() + ": Insufficient funds");
                            }
                        } finally {
                            secondLock.getLock().unlock();
                        }
                    }
                } finally {
                    firstLock.getLock().unlock();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Q24 {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(1000);

        Thread t1 = new Thread(new TransferTask(account1, account2, 300), "Thread-1");
        Thread t2 = new Thread(new TransferTask(account2, account1, 500), "Thread-2");

        t1.start();
        t2.start();
    }
}


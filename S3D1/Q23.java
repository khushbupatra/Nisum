class Ticket {
    int seats = 1;

    public synchronized void book(String name) {
        if (seats > 0) {
            System.out.println(name + " booked ticket");
            seats--;
        } else {
            System.out.println(name + " failed to book");
        }
    }
}

public class Q23 {
    public static void main(String[] args) {
        Ticket t = new Ticket();

        Thread t1 = new Thread(() -> t.book("A"));
        Thread t2 = new Thread(() -> t.book("B"));

        t1.start();
        t2.start();
    }
}

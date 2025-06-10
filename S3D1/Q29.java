class Buffer {
    int data;
    boolean empty = true;

    public synchronized void produce(int value) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        data = value;
        empty = false;
        notify();
    }

    public synchronized int consume() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        empty = true;
        notify();
        return data;
    }
}

public class Q29 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Consumed: " + buffer.consume());
            }
        });

        producer.start();
        consumer.start();
    }
}

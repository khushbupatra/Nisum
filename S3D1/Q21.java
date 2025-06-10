public class Q21 {
    public static void main(String[] args) {
        Thread even = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
            }
        });

        Thread odd = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                System.out.println("Odd: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
            }
        });

        even.start();
        odd.start();
    }
}

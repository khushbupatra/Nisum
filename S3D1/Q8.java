public class Q8 {
    public static void retryOperation(int maxRetries) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                if (Math.random() < 0.8) {
                    throw new RuntimeException("Failed");
                }
                System.out.println("Success");
                return;
            } catch (Exception e) {
                attempts++;
                try {
                    Thread.sleep((long) Math.pow(2, attempts) * 100);
                } catch (InterruptedException ignored) {}
            }
        }
        System.out.println("All retries failed");
    }

    public static void main(String[] args) {
        retryOperation(3);
    }
}

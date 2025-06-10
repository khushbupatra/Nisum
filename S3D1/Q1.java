public class Q1 {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            System.out.println(divide(10, 2));
            System.out.println(divide(5, 0));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
    }
}

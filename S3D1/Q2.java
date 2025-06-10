class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Q2 {
    public static void validateAge(int age) {
        try {
            if (age <= 0) {
                throw new InvalidAgeException("Invalid age");
            } else {
                System.out.println("Valid age: " + age);
            }
        } catch (InvalidAgeException e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(20);
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Other exception");
        }
    }
}

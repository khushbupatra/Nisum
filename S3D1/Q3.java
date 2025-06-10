import java.io.*;

class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Q3 {
    public static void validateAge(int age) {
        if (age <= 0) {
            throw new InvalidAgeException("Invalid age");
        }
    }

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            validateAge(25);
            writer.write("Valid age written to file");
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("File error");
        }
    }
}

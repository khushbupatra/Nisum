import java.util.*;

class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}

class Validator {
    public static void validate(String name, int age) {
        List<String> errors = new ArrayList<>();
        if (name == null || name.isEmpty()) {
            errors.add("Name is empty");
        }
        if (age <= 0) {
            errors.add("Age is invalid");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(String.join(", ", errors));
        }
    }
}

public class Q9 {
    public static void main(String[] args) {
        try {
            Validator.validate("", -1);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}

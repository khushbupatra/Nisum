class PaymentException extends Exception {}

final class InvalidPaymentMethodException extends PaymentException {}
final class InvalidOfferAppliedException extends PaymentException {}

public class Q6 {
    public static void paymentMethod(String type, boolean offer) throws PaymentException {
        if (!type.equals("Card") && !type.equals("UPI")) {
            throw new InvalidPaymentMethodException();
        }
        if (offer && type.equals("UPI")) {
            throw new InvalidOfferAppliedException();
        }
    }

    public static void processPaymentMethod(String type, boolean offer) {
        try {
            paymentMethod(type, offer);
            System.out.println("Payment successful");
        } catch (PaymentException e) {
            if (e instanceof InvalidPaymentMethodException) {
                System.out.println("Invalid payment method");
            } else if (e instanceof InvalidOfferAppliedException) {
                System.out.println("Invalid offer applied");
            } else {
                System.out.println("Payment error");
            }
        }
    }

    public static void main(String[] args) {
        processPaymentMethod("UPI", true);
    }
}

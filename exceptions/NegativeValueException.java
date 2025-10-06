package exceptions;

public class NegativeValueException extends IllegalArgumentException {
    public NegativeValueException(String message) {
        super(message);
    }
}
package exceptions;

public class InvalidFigureParametersException extends RuntimeException {
    public InvalidFigureParametersException(String message) {
        super(message);
    }
}
package Exception;

public class ValidationException extends IllegalArgumentException {

    public ValidationException(String s) {
        super(s);
    }
}
package framework;

public class FrameworkSystemException extends RuntimeException{

    public FrameworkSystemException(String message) {
        super(message);
    }

    public FrameworkSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public FrameworkSystemException(Throwable cause) {
        super(cause);
    }

    protected FrameworkSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

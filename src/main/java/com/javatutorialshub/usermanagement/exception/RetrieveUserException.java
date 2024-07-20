package com.javatutorialshub.usermanagement.exception;

public class RetrieveUserException extends Exception {
    public RetrieveUserException() {
    }

    public RetrieveUserException(String message) {
        super(message);
    }

    public RetrieveUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public RetrieveUserException(Throwable cause) {
        super(cause);
    }

    public RetrieveUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

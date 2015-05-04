package com.fet.carpool.serv;

public class ApException extends RuntimeException {

    private static final long serialVersionUID = -3785561143123198830L;

    public ApException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ApException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApException(String message) {
        super(message);
    }

    public ApException(Throwable cause) {
        super(cause);
    }
}

package com.libedi.demo.util;

/**
 * ResourceNotFoundException
 *
 * @author Sang-jun, Park
 * @since 2019. 02. 07
 */
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5951247263632341160L;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}

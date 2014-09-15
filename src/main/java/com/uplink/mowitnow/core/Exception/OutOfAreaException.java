package com.uplink.mowitnow.core.Exception;

/**
 * Created by walid on 13/09/14.
 */
public class OutOfAreaException extends RuntimeException {

    public OutOfAreaException(String message) {
        super(message);
    }

    public OutOfAreaException(String message, Throwable cause) {
        super(message, cause);
    }
}

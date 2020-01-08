package com.scrotifybanking.payeemanagement.exception;

import java.io.Serializable;

/**
 * The type Common exception.
 */
public class CommonException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Common exception.
     *
     * @param message the message
     */
    public CommonException(String message) {
        super(message);

    }
}

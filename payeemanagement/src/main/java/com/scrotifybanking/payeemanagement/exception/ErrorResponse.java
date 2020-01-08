package com.scrotifybanking.payeemanagement.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Error response.
 */
@Setter
@Getter
public class ErrorResponse {

    private String message;
    private int statusCode;
}
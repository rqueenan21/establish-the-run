package com.establish.the.run.client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class JobCreationException extends RuntimeException {
    public JobCreationException(String message) {
        super(message);
    }
    public JobCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
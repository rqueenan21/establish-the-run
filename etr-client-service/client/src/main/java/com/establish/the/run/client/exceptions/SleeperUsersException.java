package com.establish.the.run.client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SleeperUsersException  extends RuntimeException {
    public SleeperUsersException(String message) {
        super(message);
    }
    public SleeperUsersException(String message, Throwable cause) {
        super(message, cause);
    }
}
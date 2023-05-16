package com.establish.the.run.client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SleeperLeagueException  extends RuntimeException {
    public SleeperLeagueException(String message) {
        super(message);
    }
    public SleeperLeagueException(String message, Throwable cause) {
        super(message, cause);
    }


}

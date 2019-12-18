package ru.zagamaza.competition.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Data
public class SubLearnException extends RuntimeException {

    protected final String uuid = UUID.randomUUID().toString();
    protected HttpStatus httpStatus;

    public SubLearnException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubLearnException(String message) {
        super(message);
    }

    public SubLearnException(Throwable cause) {
        super(cause);
    }

}
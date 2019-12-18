package ru.zagamaza.competition.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class SubLearnException extends RuntimeException {

    protected final String uuid = UUID.randomUUID().toString();
    protected HttpStatus httpStatus;
    protected String args;

    public SubLearnException(String message, String args, Throwable cause) {
        super(message, cause);
        this.args = args;
    }

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
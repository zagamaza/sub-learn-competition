package ru.zagamaza.competition.exception.domain;

import org.springframework.http.HttpStatus;

public class ValidationException extends DomainException {

    {
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

}

package ru.zagamaza.competition.exception.domain;

import org.springframework.http.HttpStatus;

public class NotFoundException extends DomainException {

    {
        this.httpStatus = HttpStatus.NOT_FOUND;
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message) {
        super(message);
    }

}

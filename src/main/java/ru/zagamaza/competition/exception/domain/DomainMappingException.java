package ru.zagamaza.competition.exception.domain;

import org.springframework.http.HttpStatus;

public class DomainMappingException extends DomainException {

    {
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public DomainMappingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainMappingException(String message) {
        super(message);
    }

    public DomainMappingException(Throwable cause) {
        super(cause);
    }

}

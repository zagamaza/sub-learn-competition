package ru.zagamaza.competition.exception.domain;


import ru.zagamaza.competition.exception.SubLearnException;

public class DomainException extends SubLearnException {


    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainException(String message) {
        super(message);
    }

    public DomainException(Throwable cause) {
        super(cause);
    }


}

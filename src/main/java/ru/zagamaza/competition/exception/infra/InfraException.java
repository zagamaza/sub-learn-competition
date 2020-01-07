package ru.zagamaza.competition.exception.infra;


import ru.zagamaza.competition.exception.SubLearnException;

public class InfraException extends SubLearnException {

    public InfraException(String message, Throwable cause) {
        super(message, cause);
    }

    public InfraException(String message) {
        super(message);
    }

    public InfraException(Throwable cause) {
        super(cause);
    }

}

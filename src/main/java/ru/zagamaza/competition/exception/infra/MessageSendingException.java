package ru.zagamaza.competition.exception.infra;

import org.springframework.http.HttpStatus;

public class MessageSendingException extends InfraException {

    {
        this.httpStatus = HttpStatus.GATEWAY_TIMEOUT;
    }

    public MessageSendingException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageSendingException(String message) {
        super(message);
    }

    public MessageSendingException(Throwable cause) {
        super(cause);
    }

}

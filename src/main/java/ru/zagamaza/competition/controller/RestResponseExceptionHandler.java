package ru.zagamaza.competition.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.zagamaza.competition.controller.presenter.ErrorResponse;
import ru.zagamaza.competition.exception.SubLearnException;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class RestResponseExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(SubLearnException.class)
    protected ResponseEntity<ErrorResponse> handleCocosError(final SubLearnException ex) {
        logError(ex.getUuid(), ex.getMessage(), ex);
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getUuid(),
                LocalDateTime.now(),
                getMessage(ex.getMessage(), ex.getArgs())
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleUnexpectedError(final Exception ex) {
        String uuid = UUID.randomUUID().toString();
        logError(uuid, ex.getMessage(), ex);
        ErrorResponse errorResponse = new ErrorResponse(uuid, LocalDateTime.now(), ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException e) {
        String uuid = UUID.randomUUID().toString();
        BindingResult bindingResult = e.getBindingResult();
        String bindingMessage = "exception.binding.message";

        var errors = bindingResult.getFieldErrors().stream()
                                  .map(o -> new ErrorResponse.ErrorDetailResponse(o.getField(), o.getDefaultMessage()))
                                  .collect(Collectors.toList());

        log.error("Error {} {} {}", uuid, bindingMessage, errors, e);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(bindingMessage, LocalDateTime.now(), uuid, errors));
    }

    private void logError(String uuid, String message, Throwable throwable) {
        log.error(
                "Error {} {} {} ",
                keyValue("uuid", uuid),
                keyValue("messages", message),
                keyValue("result", throwable)
        );
    }

    private String getMessage(String key, Object... args) {
        return this.messageSource.getMessage(key, args, Locale.getDefault());
    }

}
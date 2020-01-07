package ru.zagamaza.competition.controller.presenter;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private final LocalDateTime timestamp;
    private final String message;
    private List<ErrorDetailResponse> errors = new LinkedList<>();


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorDetailResponse {

        private String field;
        private String message;

    }

}

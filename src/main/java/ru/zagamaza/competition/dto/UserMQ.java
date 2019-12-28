package ru.zagamaza.competition.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserMQ implements Serializable {

    private Long id;

    private Long telegramId;

    private String userName;

}



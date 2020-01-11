package ru.zagamaza.competition.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationModel {

    private Long id;

    private String text;

    private UserModel userDto;

    private NotificationType notificationType;

    private LocalDateTime created;

    public NotificationModel(
            String text,
            UserModel userDto,
            NotificationType notificationType
    ) {
        this.text = text;
        this.userDto = userDto;
        this.notificationType = notificationType;
    }

}

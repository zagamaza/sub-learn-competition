package ru.zagamaza.competition.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserFriendModel extends DomainModel {

    private Long userId;
    private Long userFriendId;
    private OffsetDateTime created;

}

package ru.zagamaza.competition.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;


@Data
@EqualsAndHashCode(callSuper = true)
public class UserFriendModel extends DomainModel {

    private Integer userId;
    private Integer userFriendId;
    private OffsetDateTime created;

}

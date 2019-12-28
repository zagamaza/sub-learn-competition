package ru.zagamaza.competition.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeagueModel extends DomainModel {

    private Long userId;
    private String userName;
    private Integer experience;
    private Long levelId;
    private Long leagueVersionId;
    private OffsetDateTime created;

}

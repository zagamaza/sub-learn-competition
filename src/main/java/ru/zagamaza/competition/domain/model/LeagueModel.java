package ru.zagamaza.competition.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeagueModel extends DomainModel {

    private Integer userId;
    private Integer experience;
    private Integer levelId;
    private OffsetDateTime created;

}

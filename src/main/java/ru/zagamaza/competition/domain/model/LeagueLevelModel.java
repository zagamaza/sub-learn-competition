package ru.zagamaza.competition.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class LeagueLevelModel extends DomainModel {

    @NonNull
    private OffsetDateTime created;
    private Level code;
    private String name;

}

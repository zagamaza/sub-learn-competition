package ru.zagamaza.competition.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.League;

import java.time.OffsetDateTime;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserModel extends DomainModel {

    private OffsetDateTime created;
    private Integer experience;
    private Long levelId;
    private Level level;
    private Long telegramId;
    private String userName;

    public UserModel(Long id) {
        setId(id);
    }

}

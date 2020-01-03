package ru.zagamaza.competition.infra.dao.repository;

import org.springframework.data.domain.Pageable;
import ru.zagamaza.competition.domain.model.Level;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueVersionEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserEntity;

import java.util.List;
import java.util.Map;

public interface LeagueRepository extends BaseRepository<LeagueEntity> {

    Map<LeagueEntity, UserEntity>  getByLeagueLevelCode(Level level, Pageable pageable);

    Integer getCountAll();

    boolean checkExists(Long userId);

    LeagueEntity findLastByUserId(Long userId);

    Integer getNumberInLeague(Long userId, Level code);

}

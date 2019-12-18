package ru.zagamaza.competition.infra.dao.repository;

import org.springframework.data.domain.Pageable;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueEntity;

import java.util.List;

public interface LeagueRepository extends BaseRepository<LeagueEntity> {

    Integer getCountAll();

    boolean checkExists(Integer userId);

    LeagueEntity findLastByUserId(Integer userId);

    List<LeagueEntity> getAll(Pageable pageable);

}

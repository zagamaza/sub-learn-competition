package ru.zagamaza.competition.infra.dao.repository;

import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueLevelEntity;

import java.util.List;

public interface LeagueLevelRepository extends BaseRepository<LeagueLevelEntity> {

    List<LeagueLevelEntity> findAll();

    LeagueLevelEntity getByCode(String code);

}

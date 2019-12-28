package ru.zagamaza.competition.infra.dao.repository;

import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueVersionEntity;

public interface LeagueVersionRepository {

    LeagueVersionEntity findLastVersion();

    LeagueVersionEntity newVersion();

}

package ru.zagamaza.competition.infra.dao.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueVersionEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.records.LeagueVersionRecord;
import ru.zagamaza.competition.infra.dao.repository.LeagueVersionRepository;

import static ru.zagamaza.competition.infra.dao.jooq.schema.Tables.LEAGUE_VERSION_ENTITY;

@Repository
@RequiredArgsConstructor
public class LeagueVersionRepositoryImpl implements LeagueVersionRepository {

    private final DSLContext dslContext;

    @Override
    public LeagueVersionEntity findLastVersion() {
        return dslContext
                .select()
                .from(LEAGUE_VERSION_ENTITY)
                .orderBy(LEAGUE_VERSION_ENTITY.VERSION.desc())
                .limit(1)
                .fetchOne()
                .into(LeagueVersionEntity.class);
    }

    @Override
    public LeagueVersionEntity newVersion() {
        LeagueVersionEntity leagueVersionEntity = findLastVersion();
        LeagueVersionEntity versionEntity = new LeagueVersionEntity(null, null, leagueVersionEntity.getVersion() + 1);
        LeagueVersionRecord leagueVersionRecord = dslContext.newRecord(LEAGUE_VERSION_ENTITY, versionEntity);
        leagueVersionRecord.store();
        return leagueVersionRecord.into(LeagueVersionEntity.class);
    }

}

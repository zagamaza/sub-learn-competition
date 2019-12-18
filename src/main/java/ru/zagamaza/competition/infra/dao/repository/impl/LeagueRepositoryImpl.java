package ru.zagamaza.competition.infra.dao.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ru.zagamaza.competition.exception.domain.NotFoundException;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.records.LeagueRecord;
import ru.zagamaza.competition.infra.dao.repository.LeagueRepository;

import java.util.List;

import static ru.zagamaza.competition.infra.dao.jooq.schema.Tables.LEAGUE_ENTITY;

@Repository
@RequiredArgsConstructor
public class LeagueRepositoryImpl implements LeagueRepository {

    private final DSLContext dslContext;

    @Override
    public LeagueEntity get(Integer id) {
        return dslContext
                .select()
                .from(LEAGUE_ENTITY)
                .where(LEAGUE_ENTITY.ID.eq(id))
                .fetchOptional()
                .orElseThrow(() -> generateNotFoundException(id))
                .into(LeagueEntity.class);
    }

    private NotFoundException generateNotFoundException(Integer id) {
        return new NotFoundException(
                "msz.not.found.exception"
        );
    }

    @Override
    public List<LeagueEntity> getAll(Pageable pageable) {
        return dslContext
                .select()
                .from(LEAGUE_ENTITY)
                .orderBy(LEAGUE_ENTITY.EXPERIENCE.desc())
                .offset((int)pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchInto(LeagueEntity.class);
    }

    @Override
    public Integer getCountAll() {
        return dslContext
                .select(DSL.count(LEAGUE_ENTITY.ID))
                .from(LEAGUE_ENTITY)
                .orderBy(LEAGUE_ENTITY.EXPERIENCE.desc())
                .fetchOne(0, Integer.class);
    }

    @Override
    public boolean checkExists(Integer userId) {
        return dslContext.fetchExists(
                dslContext.selectFrom(LEAGUE_ENTITY).where(LEAGUE_ENTITY.USER_ID.eq(userId)));
    }

    @Override
    public LeagueEntity findLastByUserId(Integer userId) {
        return dslContext
                .select()
                .from(LEAGUE_ENTITY)
                .where(LEAGUE_ENTITY.USER_ID.eq(userId))
                .orderBy(LEAGUE_ENTITY.CREATED.desc())
                .limit(1)
                .fetchOptional()
                .orElseThrow(() -> generateNotFoundException(userId))
                .into(LeagueEntity.class);
    }

    @Override
    public LeagueEntity create(LeagueEntity entity) {
        LeagueRecord record = generateRecord(entity);
        dslContext.executeInsert(record);
        return record.into(LeagueEntity.class);
    }

    @Override
    public LeagueEntity update(LeagueEntity entity) {
        LeagueRecord record = generateRecord(entity);
        dslContext.executeUpdate(record);
        return record.into(LeagueEntity.class);
    }

    @Override
    public void delete(Integer id) {
        dslContext.deleteFrom(LEAGUE_ENTITY)
                  .where(LEAGUE_ENTITY.ID.eq(id))
                  .execute();
    }

    private LeagueRecord generateRecord(LeagueEntity entity) {
        return dslContext.newRecord(
                LEAGUE_ENTITY,
                entity
        );
    }

}

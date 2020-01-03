package ru.zagamaza.competition.infra.dao.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SelectConditionStep;
import org.jooq.SelectJoinStep;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.zagamaza.competition.domain.model.Level;
import ru.zagamaza.competition.exception.domain.NotFoundException;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueVersionEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.records.LeagueRecord;
import ru.zagamaza.competition.infra.dao.repository.LeagueRepository;

import java.util.Map;
import java.util.stream.Collectors;

import static org.jooq.impl.DSL.*;
import static ru.zagamaza.competition.infra.dao.jooq.schema.Tables.LEAGUE_ENTITY;
import static ru.zagamaza.competition.infra.dao.jooq.schema.Tables.LEAGUE_LEVEL_ENTITY;
import static ru.zagamaza.competition.infra.dao.jooq.schema.Tables.LEAGUE_VERSION_ENTITY;
import static ru.zagamaza.competition.infra.dao.jooq.schema.Tables.USER_ENTITY;

@Repository
@RequiredArgsConstructor
public class LeagueRepositoryImpl implements LeagueRepository {

    private final DSLContext dslContext;

    @Override
    public LeagueEntity get(Long id) {
        return dslContext
                .select()
                .from(LEAGUE_ENTITY)
                .where(LEAGUE_ENTITY.ID.eq(id))
                .fetchOptional()
                .orElseThrow(() -> generateNotFoundException(id))
                .into(LeagueEntity.class);
    }

    private NotFoundException generateNotFoundException(Long id) {
        return new NotFoundException(
                "league.not.found.exception"
        );
    }

    @Override
    public Map<LeagueEntity, UserEntity> getByLeagueLevelCode(Level level, Pageable pageable) {
        LeagueVersionEntity leagueVersionEntity = dslContext
                .select(LEAGUE_VERSION_ENTITY.fields())
                .from(LEAGUE_VERSION_ENTITY)
                .orderBy(LEAGUE_VERSION_ENTITY.VERSION.desc())
                .limit(1)
                .fetchOne()
                .into(LeagueVersionEntity.class);

        return dslContext
                .select()
                .from(LEAGUE_ENTITY)
                .join(LEAGUE_LEVEL_ENTITY).on(LEAGUE_ENTITY.LEVEL_ID.eq(LEAGUE_LEVEL_ENTITY.ID))
                .join(LEAGUE_VERSION_ENTITY).on(LEAGUE_ENTITY.LEAGUE_VERSION_ID.eq(LEAGUE_VERSION_ENTITY.ID))
                .join(USER_ENTITY).on(USER_ENTITY.ID.eq(LEAGUE_ENTITY.USER_ID))
                .where(LEAGUE_VERSION_ENTITY.ID.eq(leagueVersionEntity.getId())
                                               .and(LEAGUE_LEVEL_ENTITY.CODE.eq(level.name())))
                .orderBy(LEAGUE_ENTITY.EXPERIENCE.desc())
                .offset((int)pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchGroups(
                        record -> record.into(LEAGUE_ENTITY).into(LeagueEntity.class),
                        record -> record.into(USER_ENTITY).into(UserEntity.class)
                ).entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().get(0)));
    }

    @Override
    @Transactional
    public Integer getNumberInLeague(Long userId, Level level) {

        LeagueVersionEntity leagueVersionEntity = dslContext
                .select(LEAGUE_VERSION_ENTITY.fields())
                .from(LEAGUE_VERSION_ENTITY)
                .orderBy(LEAGUE_VERSION_ENTITY.VERSION.desc())
                .limit(1)
                .fetchOne()
                .into(LeagueVersionEntity.class);


return                  dslContext.with("table").as(
                select(
                                USER_ENTITY.ID.as("userId"),
                                rowNumber().over().orderBy(LEAGUE_ENTITY.EXPERIENCE.desc()).as("rowNumber")
                        )
                        .from(LEAGUE_ENTITY)
                        .join(LEAGUE_LEVEL_ENTITY)
                        .on(LEAGUE_ENTITY.LEVEL_ID.eq(LEAGUE_LEVEL_ENTITY.ID))
                        .join(LEAGUE_VERSION_ENTITY)
                        .on(LEAGUE_ENTITY.LEAGUE_VERSION_ID.eq(LEAGUE_VERSION_ENTITY.ID))
                        .join(USER_ENTITY)
                        .on(USER_ENTITY.ID.eq(LEAGUE_ENTITY.USER_ID))
                        .where(LEAGUE_VERSION_ENTITY.ID.eq(leagueVersionEntity.getId())
                                                       .and(LEAGUE_LEVEL_ENTITY.CODE.eq(level.name())))
                        .orderBy(LEAGUE_ENTITY.EXPERIENCE.desc()))
                        .select(DSL.field(name("table","rowNumber")))
                        .from(table(name("table")))
                        .where(DSL.field(name("table","userId")).eq(userId))
                        .fetchOne().into(Integer.class);
    }

    @Override
    public Integer getCountAll() {
        return dslContext
                .select(count(LEAGUE_ENTITY.ID))
                .from(LEAGUE_ENTITY)
                .fetchOne(0, Integer.class);
    }

    @Override
    public boolean checkExists(Long userId) {
        return dslContext.fetchExists(
                dslContext.selectFrom(LEAGUE_ENTITY).where(LEAGUE_ENTITY.USER_ID.eq(userId)));
    }

    @Override
    public LeagueEntity findLastByUserId(Long userId) {
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
    public void delete(Long id) {
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

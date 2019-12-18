package ru.zagamaza.competition.infra.dao.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.zagamaza.competition.exception.domain.NotFoundException;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueLevelEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.records.LeagueLevelRecord;
import ru.zagamaza.competition.infra.dao.repository.LeagueLevelRepository;

import java.util.List;

import static ru.zagamaza.competition.infra.dao.jooq.schema.Tables.LEAGUE_LEVEL_ENTITY;

@Repository
@RequiredArgsConstructor
public class LeagueLevelRepositoryImpl implements LeagueLevelRepository {

    private final DSLContext dslContext;

    @Override
    public LeagueLevelEntity get(Integer id) {
        return dslContext
                .select()
                .from(LEAGUE_LEVEL_ENTITY)
                .where(LEAGUE_LEVEL_ENTITY.ID.eq(id))
                .fetchOptional()
                .orElseThrow(() -> generateNotFoundException(id))
                .into(LeagueLevelEntity.class);
    }

    private NotFoundException generateNotFoundException(Integer id) {
        return new NotFoundException(
                "msz.not.found.exception"
        );
    }

    @Override
    public LeagueLevelEntity create(LeagueLevelEntity entity) {
        LeagueLevelRecord record = generateRecord(entity);
        dslContext.executeInsert(record);
        return record.into(LeagueLevelEntity.class);
    }

    @Override
    public LeagueLevelEntity update(LeagueLevelEntity entity) {
        LeagueLevelRecord record = generateRecord(entity);
        dslContext.executeUpdate(record);
        return record.into(LeagueLevelEntity.class);
    }

    @Override
    public void delete(Integer id) {
        dslContext.deleteFrom(LEAGUE_LEVEL_ENTITY)
                  .where(LEAGUE_LEVEL_ENTITY.ID.eq(id))
                  .execute();
    }

    private LeagueLevelRecord generateRecord(LeagueLevelEntity entity) {
        return dslContext.newRecord(
                LEAGUE_LEVEL_ENTITY,
                entity
        );
    }

    @Override
    public List<LeagueLevelEntity> findAll() {
        return dslContext
                .select()
                .from(LEAGUE_LEVEL_ENTITY)
                .fetchInto(LeagueLevelEntity.class);
    }

    @Override
    public LeagueLevelEntity getByCode(String code) {
        return dslContext
                .select()
                .from(LEAGUE_LEVEL_ENTITY)
                .where(LEAGUE_LEVEL_ENTITY.CODE.eq(code))
                .fetchOptional()
                .orElseThrow(() -> {throw new NotFoundException(code);})
                .into(LeagueLevelEntity.class);
    }

}

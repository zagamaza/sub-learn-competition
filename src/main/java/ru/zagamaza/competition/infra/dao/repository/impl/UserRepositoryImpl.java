package ru.zagamaza.competition.infra.dao.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ru.zagamaza.competition.exception.domain.NotFoundException;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.records.UserRecord;
import ru.zagamaza.competition.infra.dao.repository.UserRepository;

import java.util.List;

import static ru.zagamaza.competition.infra.dao.jooq.schema.Tables.USER_ENTITY;
import static ru.zagamaza.competition.infra.dao.jooq.schema.Tables.USER_FRIEND_ENTITY;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final DSLContext dslContext;

    @Override
    public UserEntity get(Integer id) {
        return dslContext
                .select()
                .from(USER_ENTITY)
                .where(USER_ENTITY.ID.eq(id))
                .fetchOptional()
                .orElseThrow(() -> generateNotFoundException(id))
                .into(UserEntity.class);
    }

    @Override
    public List<UserEntity> findAll() {
        return dslContext
                .select()
                .from(USER_ENTITY)
                .fetchInto(UserEntity.class);
    }

    private NotFoundException generateNotFoundException(Integer id) {
        return new NotFoundException(
                "msz.not.found.exception"
        );
    }

    @Override
    public boolean checkExists(Integer id) {
        return dslContext.fetchExists(
                dslContext.selectFrom(USER_ENTITY).where(USER_ENTITY.ID.eq(id)));
    }

    @Override
    public UserEntity create(UserEntity entity) {
        UserRecord record = generateRecord(entity);
        dslContext.executeInsert(record);
        return record.into(UserEntity.class);
    }

    @Override
    public UserEntity update(UserEntity entity) {
        UserRecord record = generateRecord(entity);
        dslContext.executeUpdate(record);
        return record.into(UserEntity.class);

    }

    @Override
    public void delete(Integer id) {
        dslContext.deleteFrom(USER_ENTITY)
                  .where(USER_ENTITY.ID.eq(id))
                  .execute();
    }

    private UserRecord generateRecord(UserEntity entity) {
        return dslContext.newRecord(
                USER_ENTITY,
                entity
        );
    }

    @Override
    public List<UserEntity> getByUserFriendUserId(Integer userId, Pageable pageable) {
        return dslContext
                .select(USER_ENTITY.fields())
                .from(USER_ENTITY)
                .join(USER_FRIEND_ENTITY).on(USER_ENTITY.ID.eq(USER_FRIEND_ENTITY.USER_FRIEND_ID))
                .where(USER_FRIEND_ENTITY.USER_ID.eq(userId))
                .orderBy(USER_ENTITY.EXPERIENCE.desc())
                .offset((int)pageable.getOffset())
                .limit(pageable.getPageSize() - 1)
                .union(dslContext
                               .select()
                               .from(USER_ENTITY)
                               .where(USER_ENTITY.ID.eq(userId)))
                .fetchInto(UserEntity.class);
    }

    @Override
    public Integer getCountByUserFriendUserId(Integer userId) {
        return dslContext
                .select(USER_ENTITY.fields())
                .from(USER_ENTITY)
                .join(USER_FRIEND_ENTITY).on(USER_ENTITY.ID.eq(USER_FRIEND_ENTITY.USER_FRIEND_ID))
                .where(USER_FRIEND_ENTITY.USER_ID.eq(userId))
                .fetchOne(0, Integer.class);
    }

}

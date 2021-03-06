package ru.zagamaza.competition.infra.dao.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.zagamaza.competition.exception.domain.NotFoundException;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserFriendEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.records.UserFriendRecord;
import ru.zagamaza.competition.infra.dao.repository.UserFriendRepository;

import static ru.zagamaza.competition.infra.dao.jooq.schema.Tables.USER_ENTITY;
import static ru.zagamaza.competition.infra.dao.jooq.schema.Tables.USER_FRIEND_ENTITY;

@Repository
@RequiredArgsConstructor
public class UserFriendRepositoryImpl implements UserFriendRepository {

    private final DSLContext dslContext;

    @Override
    public UserFriendEntity get(Long id) {
        return dslContext
                .select()
                .from(USER_FRIEND_ENTITY)
                .where(USER_FRIEND_ENTITY.ID.eq(id))
                .fetchOptional()
                .orElseThrow(() -> generateNotFoundException(id))
                .into(UserFriendEntity.class);
    }

    private NotFoundException generateNotFoundException(Long id) {
        return new NotFoundException(
                "userFriend.not.found.exception"
        );
    }

    @Override
    public UserFriendEntity create(UserFriendEntity entity) {
        UserFriendRecord record = generateRecord(entity);
        dslContext.executeInsert(record);
        return record.into(UserFriendEntity.class);
    }

    @Override
    public UserFriendEntity update(UserFriendEntity entity) {
        UserFriendRecord record = generateRecord(entity);
        dslContext.executeUpdate(record);
        return record.into(UserFriendEntity.class);
    }

    @Override
    public void delete(Long id) {
        dslContext.deleteFrom(USER_FRIEND_ENTITY)
                  .where(USER_FRIEND_ENTITY.ID.eq(id))
                  .execute();
    }

    private UserFriendRecord generateRecord(UserFriendEntity entity) {
        return dslContext.newRecord(
                USER_FRIEND_ENTITY,
                entity
        );
    }

    @Override
    public void deleteByUserIdAndUserFriendId(Long userId, Long userFriendId) {
        dslContext.deleteFrom(USER_FRIEND_ENTITY)
                  .where(USER_FRIEND_ENTITY.USER_ID.eq(userId).and(USER_FRIEND_ENTITY.USER_FRIEND_ID.eq(userFriendId)))
                  .execute();
    }

}

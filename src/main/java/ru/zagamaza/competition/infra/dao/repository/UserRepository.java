package ru.zagamaza.competition.infra.dao.repository;

import org.springframework.data.domain.Pageable;
import ru.zagamaza.competition.domain.model.UserModel;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserEntity;

import java.util.List;

public interface UserRepository extends BaseRepository<UserEntity> {

    List<UserEntity> findAll();

    boolean checkExists(Long id);

    List<UserEntity> getByUserFriendUserId(Long userId, Pageable pageable);

    Integer getCountByUserFriendUserId(Long userId);

    UserEntity getByTelegramId(Long telegramId);

}

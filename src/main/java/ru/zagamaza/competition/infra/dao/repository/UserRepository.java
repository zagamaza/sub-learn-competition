package ru.zagamaza.competition.infra.dao.repository;

import org.springframework.data.domain.Pageable;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserEntity;

import java.util.List;

public interface UserRepository extends BaseRepository<UserEntity> {

    List<UserEntity> findAll();

    boolean checkExists(Integer id);

    List<UserEntity> getByUserFriendUserId(Integer userId, Pageable pageable);

    Integer getCountByUserFriendUserId(Integer userId);

}

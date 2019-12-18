package ru.zagamaza.competition.infra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.zagamaza.competition.domain.model.UserModel;

import java.util.List;

public interface UserInfraService extends BaseResourceInfraService<UserModel> {

    Page<UserModel> getByUserFriendUserId(Integer userId, Pageable pageable);

    void createOrUpdateExperience(Integer userId);

    List<UserModel> findAll();

}

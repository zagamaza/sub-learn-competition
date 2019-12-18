package ru.zagamaza.competition.infra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.zagamaza.competition.domain.model.UserModel;

import java.util.List;

public interface UserInfraService extends BaseResourceInfraService<UserModel> {

    Page<UserModel> getByUserFriendUserId(Long userId, Pageable pageable);

    void createOrUpdateExperience(UserModel userModel);

    List<UserModel> findAll();

    UserModel getByTelegramId(Long telegramId);

}

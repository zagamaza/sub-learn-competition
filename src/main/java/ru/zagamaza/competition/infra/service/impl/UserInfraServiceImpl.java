package ru.zagamaza.competition.infra.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.zagamaza.competition.domain.model.LeagueLevelModel;
import ru.zagamaza.competition.domain.model.Level;
import ru.zagamaza.competition.domain.model.UserModel;
import ru.zagamaza.competition.domain.service.BaseService;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserEntity;
import ru.zagamaza.competition.infra.dao.repository.UserRepository;
import ru.zagamaza.competition.infra.mapper.BaseMapper;
import ru.zagamaza.competition.infra.service.LeagueLevelInfraService;
import ru.zagamaza.competition.infra.service.UserInfraService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserInfraServiceImpl extends BaseResourceInfraServiceImpl<UserEntity, UserModel> implements UserInfraService {

    private final UserRepository repository;
    private final LeagueLevelInfraService leagueLevelInfraService;

    public UserInfraServiceImpl(
            BaseMapper<UserEntity, UserModel> baseMapper,
            BaseService<UserModel> baseService,
            UserRepository repository,
            LeagueLevelInfraService leagueLevelInfraService
    ) {
        super(repository, baseService, baseMapper);
        this.repository = repository;
        this.leagueLevelInfraService = leagueLevelInfraService;
    }

    public Page<UserModel> getByUserFriendUserId(Long userId, Pageable pageable) {
        List<UserModel> userModels = repository.getByUserFriendUserId(userId, pageable)
                                               .stream()
                                               .map(e -> getModelMapper().entityToModel(e))
                                               .collect(Collectors.toList());
        Integer count = repository.getCountByUserFriendUserId(userId);
        if (count == null && !userModels.isEmpty()) {
            count = 1;
        } else if (count == null) {
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
        return new PageImpl<>(userModels, pageable, count);
    }

    @Override
    public void createOrUpdateExperience(UserModel userModel) {
        if (!repository.checkExists(userModel.getId())) {
            LeagueLevelModel leagueLevelModel = leagueLevelInfraService.getByCode(Level.FIRST);
            userModel.setLevelId(leagueLevelModel.getId());
            create(userModel);
        } else {
            userModel = get(userModel.getId());
            userModel.setExperience(userModel.getExperience() + 1);
            update(userModel);
        }
    }

    @Override
    public List<UserModel> findAll() {
        return repository.findAll().stream()
                         .map(e -> getModelMapper().entityToModel(e))
                         .collect(Collectors.toList());
    }

    @Override
    public UserModel getByTelegramId(Long telegramId) {
        UserEntity userEntity = repository.getByTelegramId(telegramId);
        return getModelMapper().entityToModel(userEntity);
    }

    @Override
    public UserModel get(Long id) {
        UserModel userModel = super.get(id);
        LeagueLevelModel leagueLevelModel = leagueLevelInfraService.get(userModel.getLevelId());
        userModel.setLevel(leagueLevelModel.getCode());
        return userModel;
    }

}

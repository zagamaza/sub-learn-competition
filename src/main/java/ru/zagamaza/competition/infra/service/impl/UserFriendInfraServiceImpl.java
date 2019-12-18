package ru.zagamaza.competition.infra.service.impl;

import org.springframework.stereotype.Service;
import ru.zagamaza.competition.domain.model.UserFriendModel;
import ru.zagamaza.competition.domain.model.UserModel;
import ru.zagamaza.competition.domain.service.BaseService;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserFriendEntity;
import ru.zagamaza.competition.infra.dao.repository.UserFriendRepository;
import ru.zagamaza.competition.infra.dao.repository.UserRepository;
import ru.zagamaza.competition.infra.mapper.BaseMapper;
import ru.zagamaza.competition.infra.service.UserFriendInfraService;
import ru.zagamaza.competition.infra.service.UserInfraService;

@Service
public class UserFriendInfraServiceImpl extends BaseResourceInfraServiceImpl<UserFriendEntity, UserFriendModel>
        implements UserFriendInfraService {

    public UserFriendInfraServiceImpl(
            BaseMapper<UserFriendEntity, UserFriendModel> baseMapper,
            BaseService<UserFriendModel> baseService,
            UserFriendRepository repository
    ) {
        super(repository, baseService, baseMapper);
    }

    @Override
    public void deleteByUserIdAndUserFriendId(Long userId, Long userFriendId) {
        ((UserFriendRepository)getRepository()).deleteByUserIdAndUserFriendId(userId, userFriendId);
    }

}

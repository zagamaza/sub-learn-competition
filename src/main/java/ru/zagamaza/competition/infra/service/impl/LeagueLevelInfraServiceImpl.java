package ru.zagamaza.competition.infra.service.impl;

import org.springframework.stereotype.Service;
import ru.zagamaza.competition.domain.model.LeagueLevelModel;
import ru.zagamaza.competition.domain.model.LeagueModel;
import ru.zagamaza.competition.domain.model.Level;
import ru.zagamaza.competition.domain.model.UserFriendModel;
import ru.zagamaza.competition.domain.service.BaseService;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueLevelEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserFriendEntity;
import ru.zagamaza.competition.infra.dao.repository.LeagueLevelRepository;
import ru.zagamaza.competition.infra.dao.repository.UserFriendRepository;
import ru.zagamaza.competition.infra.mapper.BaseMapper;
import ru.zagamaza.competition.infra.service.LeagueLevelInfraService;
import ru.zagamaza.competition.infra.service.UserFriendInfraService;

@Service
public class LeagueLevelInfraServiceImpl extends BaseResourceInfraServiceImpl<LeagueLevelEntity, LeagueLevelModel>
        implements LeagueLevelInfraService {

    private final LeagueLevelRepository repository;

    public LeagueLevelInfraServiceImpl(
            BaseMapper<LeagueLevelEntity, LeagueLevelModel> baseMapper,
            BaseService<LeagueLevelModel> baseService,
            LeagueLevelRepository repository
    ) {
        super(repository, baseService, baseMapper);
        this.repository = repository;
    }

    @Override
    public LeagueLevelModel getByCode(Level level) {
        LeagueLevelEntity leagueLevelEntity = repository.getByCode(level.toString());
        return getModelMapper().entityToModel(leagueLevelEntity);
    }

}

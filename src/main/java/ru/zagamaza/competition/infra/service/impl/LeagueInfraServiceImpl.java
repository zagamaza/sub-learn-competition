package ru.zagamaza.competition.infra.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.zagamaza.competition.domain.model.LeagueLevelModel;
import ru.zagamaza.competition.domain.model.LeagueModel;
import ru.zagamaza.competition.domain.model.Level;
import ru.zagamaza.competition.domain.service.BaseService;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueEntity;
import ru.zagamaza.competition.infra.dao.repository.LeagueRepository;
import ru.zagamaza.competition.infra.mapper.BaseMapper;
import ru.zagamaza.competition.infra.service.LeagueInfraService;
import ru.zagamaza.competition.infra.service.LeagueLevelInfraService;
import ru.zagamaza.competition.infra.service.UserInfraService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueInfraServiceImpl extends BaseResourceInfraServiceImpl<LeagueEntity, LeagueModel>
        implements LeagueInfraService {

    private final UserInfraService userInfraService;
    private final LeagueLevelInfraService leagueLevelInfraService;
    private final LeagueRepository repository;

    public LeagueInfraServiceImpl(
            BaseMapper<LeagueEntity, LeagueModel> baseMapper,
            BaseService<LeagueModel> baseService,
            LeagueRepository repository,
            UserInfraService userInfraService,
            LeagueLevelInfraService leagueLevelInfraService
    ) {
        super(repository, baseService, baseMapper);
        this.userInfraService = userInfraService;
        this.repository = repository;
        this.leagueLevelInfraService = leagueLevelInfraService;
    }

    @Override
    public LeagueModel createOrUpdateExperience(Integer userId) {
        if (!repository.checkExists(userId)) {
            LeagueLevelModel levelModel = leagueLevelInfraService.getByCode(Level.FIRST);
            return create(LeagueModel.builder().userId(userId).levelId(levelModel.getId()).build());
        } else {
            LeagueEntity leagueEntity = repository.findLastByUserId(userId);
            LeagueModel leagueModel = getModelMapper().entityToModel(leagueEntity);
            leagueModel.setExperience(leagueModel.getExperience() + 1);
            return update(leagueModel);
        }
    }

    /**
     * Метод @Scheduled, каждый неделю в 00:00 создает для каждого пользователя строку у лиги(длится неделю)
     */
    @Scheduled(cron = "0 0 0 ? * MON")
    @Override
    public void startNewLevel() {
        userInfraService.findAll().forEach(u -> create(
                LeagueModel.builder()
                           .userId(u.getId())
                           .levelId(u.getLevelId())
                           .build())
        );
    }

    @Override
    public Page<LeagueModel> getAll(Pageable pageable) {
        List<LeagueEntity> leagueEntities = repository.getAll(pageable);
        List<LeagueModel> leagueModels = leagueEntities
                .stream()
                .map(e -> getModelMapper().entityToModel(e))
                .collect(Collectors.toList());
        Integer countAll = repository.getCountAll();
        return new PageImpl<>(leagueModels, pageable, countAll);

    }

}

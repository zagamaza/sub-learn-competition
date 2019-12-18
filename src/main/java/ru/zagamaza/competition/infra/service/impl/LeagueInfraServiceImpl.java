package ru.zagamaza.competition.infra.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.zagamaza.competition.domain.model.LeagueLevelModel;
import ru.zagamaza.competition.domain.model.LeagueModel;
import ru.zagamaza.competition.domain.model.Level;
import ru.zagamaza.competition.domain.model.UserFriendModel;
import ru.zagamaza.competition.domain.model.UserModel;
import ru.zagamaza.competition.domain.service.BaseService;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueVersionEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserEntity;
import ru.zagamaza.competition.infra.dao.repository.LeagueRepository;
import ru.zagamaza.competition.infra.dao.repository.LeagueVersionRepository;
import ru.zagamaza.competition.infra.mapper.BaseMapper;
import ru.zagamaza.competition.infra.mapper.LeagueMapper;
import ru.zagamaza.competition.infra.service.LeagueInfraService;
import ru.zagamaza.competition.infra.service.LeagueLevelInfraService;
import ru.zagamaza.competition.infra.service.UserFriendInfraService;
import ru.zagamaza.competition.infra.service.UserInfraService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LeagueInfraServiceImpl extends BaseResourceInfraServiceImpl<LeagueEntity, LeagueModel>
        implements LeagueInfraService {

    private final UserInfraService userInfraService;
    private final LeagueLevelInfraService leagueLevelInfraService;
    private final LeagueRepository repository;
    private final LeagueVersionRepository leagueVersionRepository;
    private final UserFriendInfraService userFriendInfraService;

    public LeagueInfraServiceImpl(
            BaseMapper<LeagueEntity, LeagueModel> baseMapper,
            BaseService<LeagueModel> baseService,
            LeagueRepository repository,
            UserInfraService userInfraService,
            LeagueLevelInfraService leagueLevelInfraService,
            LeagueVersionRepository leagueVersionRepository,
            UserFriendInfraService userFriendInfraService
    ) {
        super(repository, baseService, baseMapper);
        this.userInfraService = userInfraService;
        this.repository = repository;
        this.leagueLevelInfraService = leagueLevelInfraService;
        this.leagueVersionRepository = leagueVersionRepository;
        this.userFriendInfraService = userFriendInfraService;
    }

    @Override
    public LeagueModel create(LeagueModel model) {
        LeagueVersionEntity lastVersion = leagueVersionRepository.findLastVersion();
        model.setLeagueVersionId(lastVersion.getId());
        userFriendInfraService.create(new UserFriendModel(model.getUserId(), model.getUserId(), null));
        return super.create(model);
    }

    @Override
    public LeagueModel createOrUpdateExperience(UserModel userModel) {
        Long userId = userModel.getId();
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
        leagueVersionRepository.newVersion();
        userInfraService.findAll().forEach(u -> create(
                LeagueModel.builder()
                           .userId(u.getId())
                           .levelId(u.getLevelId())
                           .build())
        );
    }

    @Override
    public Page<LeagueModel> getByLeagueLevelCode(Level level, Pageable pageable) {
        Map<LeagueEntity, UserEntity> leagueEntities = repository.getByLeagueLevelCode(level, pageable);
        List<LeagueModel> leagueModels = leagueEntities
                .entrySet()
                .stream()
                .map(e -> ((LeagueMapper)getModelMapper()).entityToModel(e.getKey(), e.getValue()))
                .sorted(Comparator.comparing(LeagueModel::getExperience).reversed())
                .collect(Collectors.toList());
        Integer countAll = repository.getCountAll();
        return new PageImpl<>(leagueModels, pageable, countAll);

    }

}

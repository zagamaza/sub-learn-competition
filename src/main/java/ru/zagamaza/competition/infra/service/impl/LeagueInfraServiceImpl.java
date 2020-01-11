package ru.zagamaza.competition.infra.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.zagamaza.competition.client.NotificationClient;
import ru.zagamaza.competition.domain.model.LeagueLevelModel;
import ru.zagamaza.competition.domain.model.LeagueModel;
import ru.zagamaza.competition.domain.model.Level;
import ru.zagamaza.competition.domain.model.NotificationModel;
import ru.zagamaza.competition.domain.model.NotificationType;
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
import ru.zagamaza.competition.utils.EmojiUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LeagueInfraServiceImpl extends BaseResourceInfraServiceImpl<LeagueEntity, LeagueModel>
        implements LeagueInfraService {

    public static final String WINN_MESSAGE = "🎉 Поздравляем! 🎊 \nНа этой недели вы заняли %s место в общем рейгнге!\n✨✨✨";

    private final UserInfraService userInfraService;
    private final LeagueLevelInfraService leagueLevelInfraService;
    private final LeagueRepository repository;
    private final LeagueVersionRepository leagueVersionRepository;
    private final UserFriendInfraService userFriendInfraService;
    private final NotificationClient notificationClient;

    public LeagueInfraServiceImpl(
            BaseMapper<LeagueEntity, LeagueModel> baseMapper,
            BaseService<LeagueModel> baseService,
            LeagueRepository repository,
            UserInfraService userInfraService,
            LeagueLevelInfraService leagueLevelInfraService,
            LeagueVersionRepository leagueVersionRepository,
            NotificationClient notificationClient,
            UserFriendInfraService userFriendInfraService
    ) {
        super(repository, baseService, baseMapper);
        this.userInfraService = userInfraService;
        this.repository = repository;
        this.leagueLevelInfraService = leagueLevelInfraService;
        this.leagueVersionRepository = leagueVersionRepository;
        this.userFriendInfraService = userFriendInfraService;
        this.notificationClient = notificationClient;
    }

    @Override
    public LeagueModel createWithFriend(LeagueModel model) {
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
            return createWithFriend(LeagueModel.builder().userId(userId).levelId(levelModel.getId()).build());
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
    @Scheduled(cron = "0 0 0 * * MON", zone = "Europe/Moscow")
    @Override
    public void startNewLevel() {
        sendMessagesForWinners();
        LeagueVersionEntity leagueVersionEntity = leagueVersionRepository.newVersion();
        userInfraService.findAll().forEach(u -> create(
                LeagueModel.builder()
                           .userId(u.getId())
                           .levelId(u.getLevelId())
                           .leagueVersionId(leagueVersionEntity.getId())
                           .build())
        );
    }

    private void sendMessagesForWinners() {
        List<LeagueModel> leagueModels = getByLeagueLevelCode(Level.FIRST, PageRequest.of(0, 3)).getContent();
        leagueModels.forEach(l -> notificationClient.create(new NotificationModel(
                String.format(WINN_MESSAGE, EmojiUtils.extractEmojiPercent(leagueModels.indexOf(l) + 1)),
                new UserModel(l.getUserId()),
                NotificationType.MESSAGE
        )));

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

    @Override
    public Page<LeagueModel> getPageWithUserByUserId(Long userId) {
        UserModel userModel = userInfraService.get(userId);
        LeagueLevelModel leagueLevelModel = leagueLevelInfraService.get(userModel.getLevelId());
        Integer numberInLeague = repository.getNumberInLeague(userId, leagueLevelModel.getCode());
        return getByLeagueLevelCode(leagueLevelModel.getCode(), PageRequest.of(numberInLeague / 10, 10));
    }

}

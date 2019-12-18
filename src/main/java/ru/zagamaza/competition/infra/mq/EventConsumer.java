package ru.zagamaza.competition.infra.mq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.zagamaza.competition.domain.model.UserModel;
import ru.zagamaza.competition.dto.UserMQ;
import ru.zagamaza.competition.infra.mapper.UserMapper;
import ru.zagamaza.competition.infra.service.LeagueInfraService;
import ru.zagamaza.competition.infra.service.UserInfraService;

@Component
@RequiredArgsConstructor
public class EventConsumer {

    private final UserInfraService userInfraService;
    private final LeagueInfraService leagueInfraService;
    private final UserMapper userMapper;

    @RabbitListener(queues = "trial-word-result-1")
    public void updateUserCompetition(final UserMQ userMQ) {
        UserModel userModel = userMapper.dtoToModel(userMQ);
        userInfraService.createOrUpdateExperience(userModel);
    }

    @RabbitListener(queues = "trial-word-result-2")
    public void updateUserLeague(final UserMQ userMQ) {
        UserModel userModel = userMapper.dtoToModel(userMQ);
        leagueInfraService.createOrUpdateExperience(userModel);
    }

}

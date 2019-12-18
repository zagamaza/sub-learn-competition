package ru.zagamaza.competition.infra.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.zagamaza.competition.infra.service.LeagueInfraService;
import ru.zagamaza.competition.infra.service.UserInfraService;

@Component
@RequiredArgsConstructor
public class EventConsumer {

    private final UserInfraService userInfraService;
    private final LeagueInfraService leagueInfraService;

    @RabbitListener(queues = "trial-word-result-1")
    public void updateUserCompetition(Long userId) {
        userInfraService.createOrUpdateExperience(userId.intValue());
    }

    @RabbitListener(queues = "trial-word-result-2")
    public void updateUserLeague(Long userId) {
        leagueInfraService.createOrUpdateExperience(userId.intValue());
    }

}

package ru.zagamaza.competition.infra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.zagamaza.competition.domain.model.LeagueModel;
import ru.zagamaza.competition.domain.model.Level;
import ru.zagamaza.competition.domain.model.UserModel;

import java.util.List;

public interface LeagueInfraService extends BaseResourceInfraService<LeagueModel> {

    LeagueModel createOrUpdateExperience(UserModel userModel);

    void startNewLevel();

    Page<LeagueModel> getByLeagueLevelCode(Level level, Pageable pageable);

    Page<LeagueModel> getPageWithUserByUserId(Long userId);

}

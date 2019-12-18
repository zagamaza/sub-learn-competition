package ru.zagamaza.competition.infra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.zagamaza.competition.domain.model.LeagueModel;

import java.util.List;

public interface LeagueInfraService extends BaseResourceInfraService<LeagueModel> {

    LeagueModel createOrUpdateExperience(Integer userId);

    void startNewLevel();

    Page<LeagueModel> getAll(Pageable pageable);

}

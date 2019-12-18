package ru.zagamaza.competition.infra.service;

import ru.zagamaza.competition.domain.model.LeagueLevelModel;
import ru.zagamaza.competition.domain.model.Level;

public interface LeagueLevelInfraService extends BaseResourceInfraService<LeagueLevelModel> {

    LeagueLevelModel getByCode(Level level);


}

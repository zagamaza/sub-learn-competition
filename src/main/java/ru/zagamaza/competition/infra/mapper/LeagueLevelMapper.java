package ru.zagamaza.competition.infra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.zagamaza.competition.domain.model.LeagueLevelModel;
import ru.zagamaza.competition.domain.model.LeagueModel;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueLevelEntity;

@Mapper(componentModel = "spring")
public interface LeagueLevelMapper extends BaseMapper<LeagueLevelEntity, LeagueLevelModel> {

    LeagueLevelModel entityToModel(LeagueLevelEntity entity);

    LeagueLevelEntity modelToEntity(LeagueLevelModel model);

}

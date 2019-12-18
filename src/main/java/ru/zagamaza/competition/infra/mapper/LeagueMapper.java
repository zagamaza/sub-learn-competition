package ru.zagamaza.competition.infra.mapper;

import org.mapstruct.Mapper;
import ru.zagamaza.competition.domain.model.LeagueModel;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueEntity;

@Mapper(componentModel = "spring")
public interface LeagueMapper extends BaseMapper<LeagueEntity, LeagueModel> {

    LeagueModel entityToModel(LeagueEntity entity);

    LeagueEntity modelToEntity(LeagueModel model);

}

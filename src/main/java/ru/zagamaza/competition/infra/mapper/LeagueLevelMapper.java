package ru.zagamaza.competition.infra.mapper;

import org.mapstruct.Mapper;
import ru.zagamaza.competition.domain.model.LeagueLevelModel;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueLevelEntity;

@Mapper(componentModel = "spring", uses = DateMapper.class)
public interface LeagueLevelMapper extends BaseMapper<LeagueLevelEntity, LeagueLevelModel> {

    LeagueLevelModel entityToModel(LeagueLevelEntity entity);

    LeagueLevelEntity modelToEntity(LeagueLevelModel model);

}

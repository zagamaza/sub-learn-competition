package ru.zagamaza.competition.infra.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.zagamaza.competition.domain.model.LeagueModel;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.LeagueEntity;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserEntity;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class, DateMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LeagueMapper extends BaseMapper<LeagueEntity, LeagueModel> {

    LeagueModel entityToModel(LeagueEntity entity);

    @Mapping(target = "experience", source = "entity.experience")
    @Mapping(target = "levelId", source = "entity.levelId")
    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "created", source = "entity.created")
    @Mapping(target = "userId", source = "userEntity.id")
    @Mapping(target = "userName", source = "userEntity.userName")
    LeagueModel entityToModel(LeagueEntity entity, UserEntity userEntity);

    LeagueEntity modelToEntity(LeagueModel model);

}

package ru.zagamaza.competition.infra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.zagamaza.competition.domain.model.UserModel;
import ru.zagamaza.competition.dto.UserMQ;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserEntity;

@Mapper(componentModel = "spring", uses = DateMapper.class)
public interface UserMapper extends BaseMapper<UserEntity, UserModel> {

    UserModel entityToModel(UserEntity entity);

    UserEntity modelToEntity(UserModel model);

    @Mapping(target = "created", ignore = true)
    UserModel dtoToModel(UserMQ dto);

}

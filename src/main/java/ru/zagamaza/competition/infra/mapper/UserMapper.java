package ru.zagamaza.competition.infra.mapper;

import org.mapstruct.Mapper;
import ru.zagamaza.competition.domain.model.UserModel;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserEntity, UserModel> {

    UserModel entityToModel(UserEntity entity);

    UserEntity modelToEntity(UserModel model);

}

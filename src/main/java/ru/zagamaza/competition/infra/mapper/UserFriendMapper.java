package ru.zagamaza.competition.infra.mapper;

import org.mapstruct.Mapper;
import ru.zagamaza.competition.domain.model.UserFriendModel;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos.UserFriendEntity;

@Mapper(componentModel = "spring", uses = DateMapper.class)
public interface UserFriendMapper extends BaseMapper<UserFriendEntity, UserFriendModel> {

    UserFriendModel entityToModel(UserFriendEntity entity);

    UserFriendEntity modelToEntity(UserFriendModel model);

}

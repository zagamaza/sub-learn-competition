package ru.zagamaza.competition.infra.mapper;

import ru.zagamaza.competition.domain.model.DomainModel;
import ru.zagamaza.competition.infra.dao.entity.Entity;

public interface BaseMapper<E extends Entity, D extends DomainModel> {

    D entityToModel(E entity);

    E modelToEntity(D model);

}

package ru.zagamaza.competition.infra.service.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.zagamaza.competition.domain.model.DomainModel;
import ru.zagamaza.competition.domain.service.BaseService;
import ru.zagamaza.competition.infra.dao.entity.Entity;
import ru.zagamaza.competition.infra.dao.repository.BaseRepository;
import ru.zagamaza.competition.infra.mapper.BaseMapper;

@RequiredArgsConstructor
@Getter
public abstract class BaseResourceInfraServiceImpl<E extends Entity, M extends DomainModel> {

    private final BaseRepository<E> repository;
    private final BaseService<M> baseService;
    private final BaseMapper<E, M> modelMapper;

    public M get(Integer id) {
        E entity = repository.get(id);
        return modelMapper.entityToModel(entity);
    }

    public M create(M model) {
        E entity = modelMapper.modelToEntity(model);
        entity = repository.create(entity);
        return modelMapper.entityToModel(entity);
    }

    public M update(M model) {
        E entity = modelMapper.modelToEntity(model);
        entity = repository.update(entity);
        return modelMapper.entityToModel(entity);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

}

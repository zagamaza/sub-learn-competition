package ru.zagamaza.competition.infra.service;

import ru.zagamaza.competition.domain.model.DomainModel;

public interface BaseResourceInfraService<M extends DomainModel> {
    M get(Integer id);

    M create(M model);

    M update(M resource);

    void delete(Integer id);


}

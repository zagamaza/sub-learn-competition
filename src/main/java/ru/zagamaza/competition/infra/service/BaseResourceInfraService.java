package ru.zagamaza.competition.infra.service;

import ru.zagamaza.competition.domain.model.DomainModel;

public interface BaseResourceInfraService<M extends DomainModel> {

    M get(Long id);

    M create(M model);

    M update(M resource);

    void delete(Long id);


}

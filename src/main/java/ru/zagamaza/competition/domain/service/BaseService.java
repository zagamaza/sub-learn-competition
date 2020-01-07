package ru.zagamaza.competition.domain.service;

import ru.zagamaza.competition.domain.model.DomainModel;

public interface BaseService <D extends DomainModel> {
    void populate(D dto);
}

package ru.zagamaza.competition.infra.dao.repository;

import ru.zagamaza.competition.infra.dao.entity.Entity;

public interface BaseRepository<E extends Entity> {

    E get(Integer id);

    E create(E entity);

    E update(E entity);

    void delete(Integer id);

}

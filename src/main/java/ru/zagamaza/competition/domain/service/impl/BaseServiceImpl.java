package ru.zagamaza.competition.domain.service.impl;

import org.springframework.stereotype.Service;
import ru.zagamaza.competition.domain.model.DomainModel;
import ru.zagamaza.competition.domain.service.BaseService;

import java.util.UUID;

@Service
public class BaseServiceImpl <D extends DomainModel> implements BaseService <D> {

    @Override
    public void populate(D dto) {
//        dto.setId(UUID.randomUUID().toString());
        System.out.println("d");
    }

}

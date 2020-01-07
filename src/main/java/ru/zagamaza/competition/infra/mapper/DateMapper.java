package ru.zagamaza.competition.infra.mapper;


import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

@Mapper(componentModel = "spring")
public class DateMapper {

    public OffsetDateTime localDateTimeToDate(LocalDateTime localDateTime) {
        return OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.UTC);
    }

    public LocalDateTime dateToLocalDateTime(OffsetDateTime offsetDateTime) {
        return offsetDateTime.toLocalDateTime();
    }

}

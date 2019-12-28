/*
 * This file is generated by jOOQ.
 */
package ru.zagamaza.competition.infra.dao.jooq.schema;


import javax.annotation.Generated;

import ru.zagamaza.competition.infra.dao.jooq.schema.tables.League;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.LeagueLevel;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.LeagueVersion;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.User;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.UserFriend;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * Таблица лиги, опыт всех пользователей
     */
    public static final League LEAGUE_ENTITY = ru.zagamaza.competition.infra.dao.jooq.schema.tables.League.LEAGUE_ENTITY;

    /**
     * Таблица уровней лиг
     */
    public static final LeagueLevel LEAGUE_LEVEL_ENTITY = ru.zagamaza.competition.infra.dao.jooq.schema.tables.LeagueLevel.LEAGUE_LEVEL_ENTITY;

    /**
     * Таблица версий уровня
     */
    public static final LeagueVersion LEAGUE_VERSION_ENTITY = ru.zagamaza.competition.infra.dao.jooq.schema.tables.LeagueVersion.LEAGUE_VERSION_ENTITY;

    /**
     * Таблица пользователей и его опыта
     */
    public static final User USER_ENTITY = ru.zagamaza.competition.infra.dao.jooq.schema.tables.User.USER_ENTITY;

    /**
     * Таблица связи друзей
     */
    public static final UserFriend USER_FRIEND_ENTITY = ru.zagamaza.competition.infra.dao.jooq.schema.tables.UserFriend.USER_FRIEND_ENTITY;
}
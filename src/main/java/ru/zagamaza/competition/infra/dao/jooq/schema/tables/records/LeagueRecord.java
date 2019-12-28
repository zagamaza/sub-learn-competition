/*
 * This file is generated by jOOQ.
 */
package ru.zagamaza.competition.infra.dao.jooq.schema.tables.records;


import java.time.OffsetDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import ru.zagamaza.competition.infra.dao.jooq.schema.tables.League;


/**
 * Таблица лиги, опыт всех пользователей
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LeagueRecord extends UpdatableRecordImpl<LeagueRecord> implements Record6<Long, Long, Integer, Long, Long, OffsetDateTime> {

    private static final long serialVersionUID = -1446417060;

    /**
     * Setter for <code>public.league.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.league.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.league.user_id</code>. идентификатор пользователя
     */
    public void setUserId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.league.user_id</code>. идентификатор пользователя
     */
    public Long getUserId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.league.experience</code>. Количество опыта
     */
    public void setExperience(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.league.experience</code>. Количество опыта
     */
    public Integer getExperience() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.league.level_id</code>. идентификатор уровня лиги
     */
    public void setLevelId(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.league.level_id</code>. идентификатор уровня лиги
     */
    public Long getLevelId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.league.league_version_id</code>. идентификатор версии уровня лиги
     */
    public void setLeagueVersionId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.league.league_version_id</code>. идентификатор версии уровня лиги
     */
    public Long getLeagueVersionId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.league.created</code>.
     */
    public void setCreated(OffsetDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.league.created</code>.
     */
    public OffsetDateTime getCreated() {
        return (OffsetDateTime) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, Long, Integer, Long, Long, OffsetDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, Long, Integer, Long, Long, OffsetDateTime> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return League.LEAGUE_ENTITY.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return League.LEAGUE_ENTITY.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return League.LEAGUE_ENTITY.EXPERIENCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field4() {
        return League.LEAGUE_ENTITY.LEVEL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return League.LEAGUE_ENTITY.LEAGUE_VERSION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<OffsetDateTime> field6() {
        return League.LEAGUE_ENTITY.CREATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getExperience();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component4() {
        return getLevelId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getLeagueVersionId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime component6() {
        return getCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getExperience();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value4() {
        return getLevelId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getLeagueVersionId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime value6() {
        return getCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeagueRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeagueRecord value2(Long value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeagueRecord value3(Integer value) {
        setExperience(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeagueRecord value4(Long value) {
        setLevelId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeagueRecord value5(Long value) {
        setLeagueVersionId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeagueRecord value6(OffsetDateTime value) {
        setCreated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeagueRecord values(Long value1, Long value2, Integer value3, Long value4, Long value5, OffsetDateTime value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LeagueRecord
     */
    public LeagueRecord() {
        super(League.LEAGUE_ENTITY);
    }

    /**
     * Create a detached, initialised LeagueRecord
     */
    public LeagueRecord(Long id, Long userId, Integer experience, Long levelId, Long leagueVersionId, OffsetDateTime created) {
        super(League.LEAGUE_ENTITY);

        set(0, id);
        set(1, userId);
        set(2, experience);
        set(3, levelId);
        set(4, leagueVersionId);
        set(5, created);
    }
}
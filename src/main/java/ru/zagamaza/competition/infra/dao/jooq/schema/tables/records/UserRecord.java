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

import ru.zagamaza.competition.infra.dao.jooq.schema.tables.User;


/**
 * Таблица пользователей и его опыта
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record6<Long, OffsetDateTime, Integer, Long, Long, String> {

    private static final long serialVersionUID = 640573636;

    /**
     * Setter for <code>public.user.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.user.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.user.created</code>.
     */
    public void setCreated(OffsetDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.user.created</code>.
     */
    public OffsetDateTime getCreated() {
        return (OffsetDateTime) get(1);
    }

    /**
     * Setter for <code>public.user.experience</code>. Количество опыта
     */
    public void setExperience(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.user.experience</code>. Количество опыта
     */
    public Integer getExperience() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.user.level_id</code>. идентификатор уровня лиги
     */
    public void setLevelId(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.user.level_id</code>. идентификатор уровня лиги
     */
    public Long getLevelId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.user.telegram_id</code>. идентификатор пользователя telegram
     */
    public void setTelegramId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.user.telegram_id</code>. идентификатор пользователя telegram
     */
    public Long getTelegramId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.user.user_name</code>. имя пользователя
     */
    public void setUserName(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.user.user_name</code>. имя пользователя
     */
    public String getUserName() {
        return (String) get(5);
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
    public Row6<Long, OffsetDateTime, Integer, Long, Long, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, OffsetDateTime, Integer, Long, Long, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return User.USER_ENTITY.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<OffsetDateTime> field2() {
        return User.USER_ENTITY.CREATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return User.USER_ENTITY.EXPERIENCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field4() {
        return User.USER_ENTITY.LEVEL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return User.USER_ENTITY.TELEGRAM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return User.USER_ENTITY.USER_NAME;
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
    public OffsetDateTime component2() {
        return getCreated();
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
        return getTelegramId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getUserName();
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
    public OffsetDateTime value2() {
        return getCreated();
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
        return getTelegramId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getUserName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value2(OffsetDateTime value) {
        setCreated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value3(Integer value) {
        setExperience(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value4(Long value) {
        setLevelId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value5(Long value) {
        setTelegramId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value6(String value) {
        setUserName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord values(Long value1, OffsetDateTime value2, Integer value3, Long value4, Long value5, String value6) {
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
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER_ENTITY);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Long id, OffsetDateTime created, Integer experience, Long levelId, Long telegramId, String userName) {
        super(User.USER_ENTITY);

        set(0, id);
        set(1, created);
        set(2, experience);
        set(3, levelId);
        set(4, telegramId);
        set(5, userName);
    }
}
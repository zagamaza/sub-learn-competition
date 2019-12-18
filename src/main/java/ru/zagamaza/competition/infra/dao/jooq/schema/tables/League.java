/*
 * This file is generated by jOOQ.
 */
package ru.zagamaza.competition.infra.dao.jooq.schema.tables;


import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import ru.zagamaza.competition.infra.dao.jooq.schema.Indexes;
import ru.zagamaza.competition.infra.dao.jooq.schema.Keys;
import ru.zagamaza.competition.infra.dao.jooq.schema.Public;
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.records.LeagueRecord;


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
public class League extends TableImpl<LeagueRecord> {

    private static final long serialVersionUID = -843562539;

    /**
     * The reference instance of <code>public.league</code>
     */
    public static final League LEAGUE_ENTITY = new League();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LeagueRecord> getRecordType() {
        return LeagueRecord.class;
    }

    /**
     * The column <code>public.league.id</code>.
     */
    public final TableField<LeagueRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('league_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.league.user_id</code>. идентификатор пользователя
     */
    public final TableField<LeagueRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "идентификатор пользователя");

    /**
     * The column <code>public.league.experience</code>. Количество опыта
     */
    public final TableField<LeagueRecord, Integer> EXPERIENCE = createField("experience", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "Количество опыта");

    /**
     * The column <code>public.league.level_id</code>. идентификатор уровня лиги
     */
    public final TableField<LeagueRecord, Integer> LEVEL_ID = createField("level_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "идентификатор уровня лиги");

    /**
     * The column <code>public.league.created</code>.
     */
    public final TableField<LeagueRecord, OffsetDateTime> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE)), this, "");

    /**
     * Create a <code>public.league</code> table reference
     */
    public League() {
        this(DSL.name("league"), null);
    }

    /**
     * Create an aliased <code>public.league</code> table reference
     */
    public League(String alias) {
        this(DSL.name(alias), LEAGUE_ENTITY);
    }

    /**
     * Create an aliased <code>public.league</code> table reference
     */
    public League(Name alias) {
        this(alias, LEAGUE_ENTITY);
    }

    private League(Name alias, Table<LeagueRecord> aliased) {
        this(alias, aliased, null);
    }

    private League(Name alias, Table<LeagueRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Таблица лиги, опыт всех пользователей"));
    }

    public <O extends Record> League(Table<O> child, ForeignKey<O, LeagueRecord> key) {
        super(child, key, LEAGUE_ENTITY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.LEAGUE_LEVEL_ID_IX, Indexes.LEAGUE_PKEY, Indexes.LEAGUE_USER_ID_IX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LeagueRecord, Integer> getIdentity() {
        return Keys.IDENTITY_LEAGUE_ENTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LeagueRecord> getPrimaryKey() {
        return Keys.LEAGUE_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LeagueRecord>> getKeys() {
        return Arrays.<UniqueKey<LeagueRecord>>asList(Keys.LEAGUE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LeagueRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LeagueRecord, ?>>asList(Keys.LEAGUE__LEAGUE_USER_ID_FK, Keys.LEAGUE__USER_LEVEL_ID_FK);
    }

    public User user() {
        return new User(this, Keys.LEAGUE__LEAGUE_USER_ID_FK);
    }

    public LeagueLevel leagueLevel() {
        return new LeagueLevel(this, Keys.LEAGUE__USER_LEVEL_ID_FK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public League as(String alias) {
        return new League(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public League as(Name alias) {
        return new League(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public League rename(String name) {
        return new League(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public League rename(Name name) {
        return new League(name, null);
    }
}

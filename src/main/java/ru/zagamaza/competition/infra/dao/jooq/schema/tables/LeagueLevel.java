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
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.records.LeagueLevelRecord;


/**
 * Таблица уровней лиг
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LeagueLevel extends TableImpl<LeagueLevelRecord> {

    private static final long serialVersionUID = 957120123;

    /**
     * The reference instance of <code>public.league_level</code>
     */
    public static final LeagueLevel LEAGUE_LEVEL_ENTITY = new LeagueLevel();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LeagueLevelRecord> getRecordType() {
        return LeagueLevelRecord.class;
    }

    /**
     * The column <code>public.league_level.id</code>.
     */
    public final TableField<LeagueLevelRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('league_level_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.league_level.created</code>.
     */
    public final TableField<LeagueLevelRecord, OffsetDateTime> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE)), this, "");

    /**
     * The column <code>public.league_level.code</code>. Код
     */
    public final TableField<LeagueLevelRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "Код");

    /**
     * The column <code>public.league_level.name</code>. Наименование
     */
    public final TableField<LeagueLevelRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "Наименование");

    /**
     * Create a <code>public.league_level</code> table reference
     */
    public LeagueLevel() {
        this(DSL.name("league_level"), null);
    }

    /**
     * Create an aliased <code>public.league_level</code> table reference
     */
    public LeagueLevel(String alias) {
        this(DSL.name(alias), LEAGUE_LEVEL_ENTITY);
    }

    /**
     * Create an aliased <code>public.league_level</code> table reference
     */
    public LeagueLevel(Name alias) {
        this(alias, LEAGUE_LEVEL_ENTITY);
    }

    private LeagueLevel(Name alias, Table<LeagueLevelRecord> aliased) {
        this(alias, aliased, null);
    }

    private LeagueLevel(Name alias, Table<LeagueLevelRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Таблица уровней лиг"));
    }

    public <O extends Record> LeagueLevel(Table<O> child, ForeignKey<O, LeagueLevelRecord> key) {
        super(child, key, LEAGUE_LEVEL_ENTITY);
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
        return Arrays.<Index>asList(Indexes.LEAGUE_LEVEL_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LeagueLevelRecord, Long> getIdentity() {
        return Keys.IDENTITY_LEAGUE_LEVEL_ENTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LeagueLevelRecord> getPrimaryKey() {
        return Keys.LEAGUE_LEVEL_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LeagueLevelRecord>> getKeys() {
        return Arrays.<UniqueKey<LeagueLevelRecord>>asList(Keys.LEAGUE_LEVEL_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeagueLevel as(String alias) {
        return new LeagueLevel(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeagueLevel as(Name alias) {
        return new LeagueLevel(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LeagueLevel rename(String name) {
        return new LeagueLevel(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LeagueLevel rename(Name name) {
        return new LeagueLevel(name, null);
    }
}

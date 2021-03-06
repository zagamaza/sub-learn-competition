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
import ru.zagamaza.competition.infra.dao.jooq.schema.tables.records.LeagueVersionRecord;


/**
 * Таблица версий уровня
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LeagueVersion extends TableImpl<LeagueVersionRecord> {

    private static final long serialVersionUID = -1021964356;

    /**
     * The reference instance of <code>public.league_version</code>
     */
    public static final LeagueVersion LEAGUE_VERSION_ENTITY = new LeagueVersion();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LeagueVersionRecord> getRecordType() {
        return LeagueVersionRecord.class;
    }

    /**
     * The column <code>public.league_version.id</code>.
     */
    public final TableField<LeagueVersionRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('league_version_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.league_version.created</code>.
     */
    public final TableField<LeagueVersionRecord, OffsetDateTime> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE)), this, "");

    /**
     * The column <code>public.league_version.version</code>. Версия лиги
     */
    public final TableField<LeagueVersionRecord, Integer> VERSION = createField("version", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "Версия лиги");

    /**
     * Create a <code>public.league_version</code> table reference
     */
    public LeagueVersion() {
        this(DSL.name("league_version"), null);
    }

    /**
     * Create an aliased <code>public.league_version</code> table reference
     */
    public LeagueVersion(String alias) {
        this(DSL.name(alias), LEAGUE_VERSION_ENTITY);
    }

    /**
     * Create an aliased <code>public.league_version</code> table reference
     */
    public LeagueVersion(Name alias) {
        this(alias, LEAGUE_VERSION_ENTITY);
    }

    private LeagueVersion(Name alias, Table<LeagueVersionRecord> aliased) {
        this(alias, aliased, null);
    }

    private LeagueVersion(Name alias, Table<LeagueVersionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Таблица версий уровня"));
    }

    public <O extends Record> LeagueVersion(Table<O> child, ForeignKey<O, LeagueVersionRecord> key) {
        super(child, key, LEAGUE_VERSION_ENTITY);
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
        return Arrays.<Index>asList(Indexes.LEAGUE_VERSION_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LeagueVersionRecord, Long> getIdentity() {
        return Keys.IDENTITY_LEAGUE_VERSION_ENTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LeagueVersionRecord> getPrimaryKey() {
        return Keys.LEAGUE_VERSION_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LeagueVersionRecord>> getKeys() {
        return Arrays.<UniqueKey<LeagueVersionRecord>>asList(Keys.LEAGUE_VERSION_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeagueVersion as(String alias) {
        return new LeagueVersion(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeagueVersion as(Name alias) {
        return new LeagueVersion(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LeagueVersion rename(String name) {
        return new LeagueVersion(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LeagueVersion rename(Name name) {
        return new LeagueVersion(name, null);
    }
}

/*
 * This file is generated by jOOQ.
 */
package ru.zagamaza.competition.infra.dao.jooq.schema.tables.pojos;


import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.annotation.Generated;

import ru.zagamaza.competition.infra.dao.entity.Entity;


/**
 * Таблица связи друзей
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserFriendEntity implements Entity, Serializable {

    private static final long serialVersionUID = -1674669585;

    private Long           id;
    private Long           userId;
    private Long           userFriendId;
    private OffsetDateTime created;

    public UserFriendEntity() {}

    public UserFriendEntity(UserFriendEntity value) {
        this.id = value.id;
        this.userId = value.userId;
        this.userFriendId = value.userFriendId;
        this.created = value.created;
    }

    public UserFriendEntity(
        Long           id,
        Long           userId,
        Long           userFriendId,
        OffsetDateTime created
    ) {
        this.id = id;
        this.userId = userId;
        this.userFriendId = userFriendId;
        this.created = created;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserFriendId() {
        return this.userFriendId;
    }

    public void setUserFriendId(Long userFriendId) {
        this.userFriendId = userFriendId;
    }

    public OffsetDateTime getCreated() {
        return this.created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UserFriendEntity other = (UserFriendEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!userId.equals(other.userId))
            return false;
        if (userFriendId == null) {
            if (other.userFriendId != null)
                return false;
        }
        else if (!userFriendId.equals(other.userFriendId))
            return false;
        if (created == null) {
            if (other.created != null)
                return false;
        }
        else if (!created.equals(other.created))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.userFriendId == null) ? 0 : this.userFriendId.hashCode());
        result = prime * result + ((this.created == null) ? 0 : this.created.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserFriendEntity (");

        sb.append(id);
        sb.append(", ").append(userId);
        sb.append(", ").append(userFriendId);
        sb.append(", ").append(created);

        sb.append(")");
        return sb.toString();
    }
}

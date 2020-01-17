package ru.sfedu.brms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public abstract class EntityBase implements Serializable, Entity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    @Version
    @Column(nullable = false)
    private Long version;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public Long getVersion() {
        return version;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }
}

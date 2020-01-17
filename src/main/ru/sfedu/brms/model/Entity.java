package ru.sfedu.brms.model;

import java.util.Date;

public interface Entity {

    public Long getId();
    String getUuid();
    Long getVersion();
    Date getCreatedDate();
    Date getDeletedDate();
    }

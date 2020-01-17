package ru.sfedu.brms.dao;

import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class DaoBase {
    protected EntityManager entityManager;

    @PersistenceContext(unitName = "integrations")
    @WebMethod(exclude = true)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}

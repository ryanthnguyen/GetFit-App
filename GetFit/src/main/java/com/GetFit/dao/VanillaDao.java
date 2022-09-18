package com.GetFit.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import static java.util.Objects.requireNonNull;

public class VanillaDao<T> extends AbstractDAO<T> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public VanillaDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    protected void delete(T entity) throws HibernateException {
        currentSession().delete(requireNonNull(entity));
    }


}

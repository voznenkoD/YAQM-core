package org.perspectiveJuniors.YAQM.dao;

/**
 * Created by eljetto on 4/22/15.
 */
public interface GenericDao<T> {

    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);
}
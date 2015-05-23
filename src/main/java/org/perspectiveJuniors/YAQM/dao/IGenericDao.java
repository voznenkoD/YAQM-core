package org.perspectiveJuniors.YAQM.dao;

import java.util.List;

/**
 * Created by eljetto on 4/22/15.
 */
public interface IGenericDao<T> {

    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);

}
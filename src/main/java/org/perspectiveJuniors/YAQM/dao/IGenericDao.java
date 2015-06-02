package org.perspectiveJuniors.YAQM.dao;

import org.springframework.transaction.annotation.Transactional;
/**
 * Created by eljetto on 4/22/15.
 */
@Transactional
public interface IGenericDao<T> {

    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);

}
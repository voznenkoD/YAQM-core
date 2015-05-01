package org.perspectiveJuniors.YAQM.dao.impl;


import org.hibernate.Session;
import org.perspectiveJuniors.YAQM.dao.GenericDao;
import org.perspectiveJuniors.YAQM.dao.IDaoFactory;

/**
 * Created by eljetto on 4/21/15.
 */
public class DaoFactory implements IDaoFactory{

    private Session currentSession;

    @Override
    public GenericDao getDaoUser() {
        return new DaoUser();
    }

    @Override
    public GenericDao getDaoClientQueue() {
        return new DaoClientQueue();
    }
}

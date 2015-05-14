package org.perspectiveJuniors.YAQM.dao.impl;


import org.hibernate.Session;
import org.perspectiveJuniors.YAQM.dao.IDaoClientQueue;
import org.perspectiveJuniors.YAQM.dao.IDaoFactory;
import org.perspectiveJuniors.YAQM.dao.IDaoUser;

/**
 * Created by eljetto on 4/21/15.
 */
public class DaoFactory implements IDaoFactory{

    private Session currentSession;

    @Override
    public IDaoUser getDaoUser() {
        return new DaoUser();
    }

    @Override
    public IDaoClientQueue getDaoClientQueue() {
        return new DaoClientQueue();
    }
}

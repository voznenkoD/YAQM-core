package org.perspectiveJuniors.YAQM.dao;

/**
 * Created by Всеволод on 20.04.2015.
 */
public interface IDaoFactory {
    public IDaoUser getDaoUser();
    public IDaoClientQueue getDaoClientQueue();
}

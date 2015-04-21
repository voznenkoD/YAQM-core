package org.perspectiveJuniors.YAQM.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Всеволод on 20.04.2015.
 */
public interface IDaoFactory {
    public Connection getConnection() throws SQLException;
    public IDaoUser getDaoUser(Connection connection);
    public IDaoQueue getDaoQueue(Connection connection);
}

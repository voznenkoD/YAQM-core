package org.perspectiveJuniors.YAQM.dao;

import org.perspectiveJuniors.YAQM.entity.IQueue;
import org.perspectiveJuniors.YAQM.entity.impl.ClientQueue;

import java.util.List;

/**
 * Created by Всеволод on 20.04.2015.
 */
public interface IDaoClientQueue extends IGenericDao<IQueue>{
    public List<ClientQueue> getAllQueuesForManager(long managerId);
    public List<ClientQueue> getAllQueuesForUser(long userId);
}

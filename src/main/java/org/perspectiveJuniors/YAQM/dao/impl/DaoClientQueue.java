package org.perspectiveJuniors.YAQM.dao.impl;

import org.perspectiveJuniors.YAQM.dao.IDaoClientQueue;
import org.perspectiveJuniors.YAQM.entity.AbstractQueue;
import org.perspectiveJuniors.YAQM.entity.impl.ClientQueue;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by eljetto on 4/21/15.
 */
public class DaoClientQueue extends GenericDao<AbstractQueue> implements IDaoClientQueue {

    public List<ClientQueue> getAllQueuesForManager(long managerId){
        Query query = this.em.createQuery("select c from ClientQueue as clientQueue left join clientQueue.managerSet");

        return null;
    }
    public List<ClientQueue> getAllQueuesForUser(long userId){
        return null;
    }
}

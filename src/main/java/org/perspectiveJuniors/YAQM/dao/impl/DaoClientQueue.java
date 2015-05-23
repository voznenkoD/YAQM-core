package org.perspectiveJuniors.YAQM.dao.impl;

import org.perspectiveJuniors.YAQM.dao.IDaoClientQueue;
import org.perspectiveJuniors.YAQM.entity.IQueue;
import org.perspectiveJuniors.YAQM.entity.impl.ClientQueue;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eljetto on 4/21/15.
 */
public class DaoClientQueue extends GenericDao<IQueue> implements IDaoClientQueue {

    public List<ClientQueue> getAllQueuesForManager(long managerId){
        String stringQuery="SELECT * FROM TABLE CLIENT_QUEUE WHERE ";
        Query query = this.em.createNativeQuery(stringQuery);

    }
    public List<ClientQueue> getAllQueuesForUser(long userId){

    }
}

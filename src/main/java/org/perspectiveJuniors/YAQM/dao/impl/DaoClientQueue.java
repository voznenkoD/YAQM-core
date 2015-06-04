package org.perspectiveJuniors.YAQM.dao.impl;


import org.perspectiveJuniors.YAQM.dao.IDaoClientQueue;
import org.perspectiveJuniors.YAQM.entity.AbstractQueue;
import org.perspectiveJuniors.YAQM.entity.impl.ClientQueue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by eljetto on 4/21/15.
 */

@Repository
@Transactional
@Qualifier("daoClientQueue")
public class DaoClientQueue extends GenericDao<AbstractQueue> implements IDaoClientQueue {

    public List<ClientQueue> getAllQueuesForManager(long managerId){
        String stringQuery="SELECT cq FROM ClientQueue cq, IN (cq.managerSet) unit WHERE unit = :managerId";
        Query query = this.em.createQuery(stringQuery).setParameter("managerId",managerId);
        List<ClientQueue> list = query.getResultList();
        return list;
    }
    public List<ClientQueue> getAllQueuesForUser(long userId){
        String stringQuery="SELECT cq FROM ClientQueue cq, IN (cq.clientList) unit WHERE unit = :userId";
        Query query = this.em.createQuery(stringQuery).setParameter("userId",userId);
        List<ClientQueue> list = query.getResultList();
        return list;
    }
}

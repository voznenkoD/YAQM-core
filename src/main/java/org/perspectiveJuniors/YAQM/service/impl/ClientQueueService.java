package org.perspectiveJuniors.YAQM.service.impl;

import java.util.List;

import org.perspectiveJuniors.YAQM.dao.IDaoClientQueue;
import org.perspectiveJuniors.YAQM.dao.IDaoUser;
import org.perspectiveJuniors.YAQM.dao.impl.DaoClientQueue;
import org.perspectiveJuniors.YAQM.dao.impl.DaoFactory;
import org.perspectiveJuniors.YAQM.dao.impl.DaoUser;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.IQueue;
import org.perspectiveJuniors.YAQM.entity.impl.ClientQueue;
import org.perspectiveJuniors.YAQM.exception.ClientAlreadyInQueueException;
import org.perspectiveJuniors.YAQM.exception.NotRegisteredUserException;
import org.perspectiveJuniors.YAQM.service.IClientQueueService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Всеволод on 11.04.2015.
 * eljetto
 */
public class ClientQueueService implements IClientQueueService {

    @Autowired
    private DaoFactory daoFactory;

    private IDaoClientQueue queueDao = daoFactory.getDaoClientQueue();
    private IDaoUser userDao = daoFactory.getDaoUser();

    @Override
    public void addUserToQueue(long userId, long queueId)
            throws NotRegisteredUserException, ClientAlreadyInQueueException {
        if(userDao.find(userId) != null) {
            ClientQueue clientQueue = (ClientQueue) queueDao.find(queueId);
            clientQueue.addClient(userId);
            queueDao.update(clientQueue);
        } else {
            throw new NotRegisteredUserException();
        }
    }

    @Override
    public long createNewQueue() {
        return queueDao.create();
    }

    @Override
    public AbstractUser pickUpNextUserFromQueue(long queueId) {
        ClientQueue clientQueue = (ClientQueue) queueDao.find(queueId);
        return userDao.find(clientQueue.getNextClientId());
    }

    @Override
    public List<ClientQueue> getQueuesOperatedByUser(long managerId) {
        return queueDao.getAllQueuesForManager(managerId);
    }

    @Override
    public List<ClientQueue> getQueuesThatUserIsIn(long userId) {
        return queueDao.getAllQueuesForUser(userId);
    }

}

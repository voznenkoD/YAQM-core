package org.perspectiveJuniors.YAQM.service.impl;

import java.util.List;

import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.impl.ClientQueue;
import org.perspectiveJuniors.YAQM.exception.NotRegisteredUserException;
import org.perspectiveJuniors.YAQM.service.IQueueService;

/**
 * Created by Всеволод on 11.04.2015.
 */
public class QueueServiceImpl implements IQueueService {

    private QueueDao queueDao = new QueueDao();
    private UserDao userDao = new UserDao();

    @Override
    public void addUserToQueue(long userId, long queueId) throws NotRegisteredUserException {
        if(userDao.read(userId) != null) {
            ClientQueue clientQueue = queueDao.read(queueId);
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
        ClientQueue clientQueue = queueDao.read();
        return userDao.read(clientQueue.getNextClient());
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

package org.perspectiveJuniors.YAQM.service;

import java.util.List;

import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.impl.ClientQueue;
import org.perspectiveJuniors.YAQM.exception.ClientAlreadyInQueueException;
import org.perspectiveJuniors.YAQM.exception.NoClientsInQueueException;
import org.perspectiveJuniors.YAQM.exception.NotRegisteredUserException;

/**
 * Created by Всеволод on 11.04.2015.
 * by eljetto
 */
public interface IClientQueueService {

    public void addUserToQueue(long userId, long queueId)
            throws NotRegisteredUserException, ClientAlreadyInQueueException;

    public long createNewQueue();

    public AbstractUser pickUpNextUserFromQueue(long queueId) throws NoClientsInQueueException;

    public List<ClientQueue> getQueuesOperatedByUser(long managerId);

    public List<ClientQueue> getQueuesThatUserIsIn(long userId);

}

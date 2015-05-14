package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.IQueue;
import org.perspectiveJuniors.YAQM.exception.ClientAlreadyInQueueException;
import org.perspectiveJuniors.YAQM.exception.ClientIsNotInQueueException;
import org.perspectiveJuniors.YAQM.exception.ManagerIsNotOperatingQueueException;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ClientQueue implements IQueue {
    private long id;
    private Queue<Long> clientList = new LinkedList<>();
    private Collection<Long> managerSet = new HashSet<>();

    public ClientQueue(){};

    public ClientQueue(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void addClient(long clientId) throws ClientAlreadyInQueueException {
        if(!clientList.contains(clientId)) {
            clientList.add(clientId);
        } else {
            throw new ClientAlreadyInQueueException();
        }
    }

    public void removeClient(long clientId) throws ClientIsNotInQueueException {
        boolean wasRemoved = clientList.remove(clientId);
        if(!wasRemoved)throw new ClientIsNotInQueueException();
    }

    public void addManager(long managerId){
        managerSet.add(managerId);
    }

    public void removeManager(long managerId) throws ManagerIsNotOperatingQueueException {
        boolean wasRemoved = managerSet.remove(managerId);
        if(!wasRemoved){
            throw new ManagerIsNotOperatingQueueException();
        }
    }

    public long getNextClientId() {
        return clientList.poll();
    }
}

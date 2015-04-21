package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.IQueue;

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

    public void addClient(long clientId){
        if(!clientList.contains(clientId))clientList.add(clientId);
        //TODO add throwing ClientAlreadyInQueueException
    }

    public void removeClient(long clientId){
        clientList.remove(clientId);
        //TODO add throwing ClientIsNotInTheQueueException
    }

    public void addManager(long managerId){
        managerSet.add(managerId);
    }

    public void removeManager(long managerId){
        managerSet.remove(managerId);
        //TODO add throwing ManagerInNotOperatingQueueException
    }

    public long getNextClientId() {
        return clientList.poll();
    }
}

package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.IQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;


public class Queue implements IQueue {
    private long id;
    private Collection<Long> clientSet = new LinkedList<>();
    private Collection<Long> managerSet = new LinkedList<>();

    public Queue(){};

    public Queue(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void addClient(long clientId){
        clientSet.add(new Long(clientId));
    }

    public void removeClient(long clientId){
        Iterator<Long> iterator = clientSet.iterator();
        while (iterator.hasNext()){
            Long element = iterator.next();
            if(element.longValue()==clientId)
                clientSet.remove(new Long(clientId));
        }
    }

    public void addManager(long managerId){
        managerSet.add(new Long(managerId));
    }

    public void removeManager(long managerId){
        Iterator<Long> iterator = managerSet.iterator();
        while (iterator.hasNext()){
            Long element = iterator.next();
            if(element.longValue()==managerId)
                managerSet.remove(new Long(managerId));
        }
    }
}

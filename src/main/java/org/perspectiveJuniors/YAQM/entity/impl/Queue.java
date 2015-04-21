package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.IQueue;

import java.util.*;


public class Queue implements IQueue {
    private long id;
    private String name;
    private List<Long> clientList = new LinkedList<>();
    private Set<Long> managerSet = new HashSet<>();

    public Queue(){};

    public Queue(long id, String name) {

        this.id = id;
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public String getName() { return name; }

    public void addClient(long clientId){
        clientList.add(new Long(clientId));
    }

    public void removeClient(long clientId){
        Iterator<Long> iterator = clientList.iterator();
        while (iterator.hasNext()){
            Long element = iterator.next();
            if(element.longValue()==clientId)
                clientList.remove(new Long(clientId));
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

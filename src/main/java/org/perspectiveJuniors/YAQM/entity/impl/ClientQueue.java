package org.perspectiveJuniors.YAQM.entity.impl;

import org.perspectiveJuniors.YAQM.entity.AbstractQueue;
import org.perspectiveJuniors.YAQM.exception.ClientAlreadyInQueueException;
import org.perspectiveJuniors.YAQM.exception.ClientIsNotInQueueException;
import org.perspectiveJuniors.YAQM.exception.ManagerIsNotOperatingQueueException;
import org.perspectiveJuniors.YAQM.exception.NoClientsInQueueException;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

/**
 * Created by vsevolod, eljetto on 04.06.15.
 */

@Component
@Entity
@DiscriminatorValue("CLIENT_QUEUE")
public class ClientQueue extends AbstractQueue {
    @ElementCollection
    @CollectionTable(name = "CLIENTS", joinColumns = @JoinColumn(name = "QUEUE_ID"))
    @Column(name="CLIENT_LIST")
    private Collection<Long> clientList = new LinkedList<>();
    @ElementCollection
    @CollectionTable(name = "MANAGERS", joinColumns = @JoinColumn(name = "QUEUE_ID"))
    @Column(name="MANAGER_SET")
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

    public long getNextClientId() throws NoClientsInQueueException{
        long clientId=-1L;
        Iterator<Long> iterator = clientList.iterator();
        while(iterator.hasNext()){
            clientId = iterator.next();
            clientList.remove(clientId);
            break;
        }
        if(clientId==-1L)
            throw new NoClientsInQueueException();
        return clientId;
    }

}

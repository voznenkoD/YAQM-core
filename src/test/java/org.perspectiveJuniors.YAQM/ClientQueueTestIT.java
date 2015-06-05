package org.perspectiveJuniors.YAQM;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.perspectiveJuniors.YAQM.entity.impl.Client;
import org.perspectiveJuniors.YAQM.entity.impl.ClientQueue;
import org.perspectiveJuniors.YAQM.entity.impl.Manager;
import org.perspectiveJuniors.YAQM.exception.ClientAlreadyInQueueException;
import org.perspectiveJuniors.YAQM.exception.ClientIsNotInQueueException;
import org.perspectiveJuniors.YAQM.exception.ManagerIsNotOperatingQueueException;
import org.perspectiveJuniors.YAQM.exception.NoClientsInQueueException;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by vsevolod on 04.06.15.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ClientQueueTestIT {

    @Test
    public void getId(){
        long id = 123L;
        ClientQueue clientQueue = new ClientQueue(id);
        assertEquals(id, clientQueue.getId());
    }

    @Test(expected = ClientAlreadyInQueueException.class)
    public void addClient() throws ClientAlreadyInQueueException,NoSuchFieldException, IllegalAccessException{
        long clientId1 = 11L;
        ClientQueue clientQueue = new ClientQueue();
        Field clientList = clientQueue.getClass().getDeclaredField("clientList");
        clientList.setAccessible(true);
        LinkedList<Client> list = new LinkedList<>();
        clientList.set(clientQueue,list);
        assertTrue(list.isEmpty());
        clientQueue.addClient(clientId1);
        assertTrue(list.size()==1);
        //test for exception awaking ClientAlreadyInQueueException
        clientQueue.addClient(clientId1);
    }

    @Test()
    public void addManager()throws NoSuchFieldException, IllegalAccessException{
        long mangerId1 = 21L;
        long mangerId2 = 22L;
        ClientQueue clientQueue = new ClientQueue();
        Field managerSet = clientQueue.getClass().getDeclaredField("managerSet");
        managerSet.setAccessible(true);
        Set <Manager> set = new HashSet<>();
        managerSet.set(clientQueue,set);
        assertTrue(set.isEmpty());
        clientQueue.addManager(mangerId1);
        clientQueue.addManager(mangerId2);
        assertTrue(set.size() == 2);
        clientQueue.addManager(mangerId1);
        assertTrue(set.size() == 2);
    }

    @Test(expected = ClientIsNotInQueueException.class)
    public void removeClient() throws ClientIsNotInQueueException, ClientAlreadyInQueueException, NoSuchFieldException, IllegalAccessException{
        long clientId1 = 11L;
        ClientQueue clientQueue = new ClientQueue();
        Field clientList = clientQueue.getClass().getDeclaredField("clientList");
        clientList.setAccessible(true);
        LinkedList<Client> list = new LinkedList<>();
        clientList.set(clientQueue,list);
        assertTrue(list.isEmpty());
        clientQueue.addClient(clientId1);
        assertTrue(list.size() == 1);
        clientQueue.removeClient(clientId1);
        assertTrue(list.isEmpty());
        //test for exception awaking ClientIsNotInQueueException
        clientQueue.removeClient(clientId1);
    }

    @Test(expected = ManagerIsNotOperatingQueueException.class)
    public void removeManager() throws ManagerIsNotOperatingQueueException, IllegalAccessException, NoSuchFieldException{
        long mangerId1 = 21L;
        ClientQueue clientQueue = new ClientQueue();
        Field managerSet = clientQueue.getClass().getDeclaredField("managerSet");
        managerSet.setAccessible(true);
        Set <Manager> set = new HashSet<>();
        managerSet.set(clientQueue,set);
        assertTrue(set.isEmpty());
        clientQueue.addManager(mangerId1);
        assertTrue(set.size() == 1);
        clientQueue.removeManager(mangerId1);
        assertTrue(set.isEmpty());
        //test for exception awaking ManagerIsNotOperatingQueueException
        clientQueue.removeManager(mangerId1);

    }

    @Test(expected = NoClientsInQueueException.class)
    public void testGetNextClientIdWithException() throws NoClientsInQueueException, ClientAlreadyInQueueException {
        long clientId1 = 11L;
        long clientId2 = 12L;
        ClientQueue clientQueue = new ClientQueue();
        clientQueue.addClient(clientId1);
        clientQueue.addClient(clientId2);
        assertEquals(clientId1, clientQueue.getNextClientId());
        assertEquals(clientId2, clientQueue.getNextClientId());
        //test for exception awaking NoClientsInQueueException
        clientQueue.getNextClientId();
    }

}

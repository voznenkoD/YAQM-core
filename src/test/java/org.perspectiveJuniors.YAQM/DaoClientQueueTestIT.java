package org.perspectiveJuniors.YAQM;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.perspectiveJuniors.YAQM.dao.IDaoClientQueue;
import org.perspectiveJuniors.YAQM.dao.IDaoUser;
import org.perspectiveJuniors.YAQM.entity.AbstractQueue;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.impl.Client;
import org.perspectiveJuniors.YAQM.entity.impl.ClientQueue;
import org.perspectiveJuniors.YAQM.entity.impl.Manager;
import org.perspectiveJuniors.YAQM.entity.impl.PersonalData;
import org.perspectiveJuniors.YAQM.exception.ClientAlreadyInQueueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Всеволод on 6/3/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class DaoClientQueueTestIT {
    @Autowired
    private IDaoUser daoUser;
    @Autowired
    private IDaoClientQueue daoClientQueue;

    private Long managerId1,managerId2;
    private Long clientId1,clientId2;

    @Before
    public void beforeMethod(){
        PersonalData personalDataManager1 = new PersonalData("Manager1", "Managa1", "Man1");
        PersonalData personalDataManager2 = new PersonalData("Manager2", "Managa2", "Man2");
        PersonalData personalDataClient1 = new PersonalData("Client1", "Clie1", "Cl1");
        PersonalData personalDataClient2 = new PersonalData("Client2", "Clie2", "Cl2");
        Manager manager1 = new Manager();
        Manager manager2 = new Manager();
        Client client1 = new Client();
        Client client2 = new Client();
        manager1.setPersonalData(personalDataManager1);
        manager2.setPersonalData(personalDataManager2);
        client1.setPersonalData(personalDataClient1);
        client1.setPersonalData(personalDataClient2);
        AbstractUser userM1 = daoUser.create(manager1);
        AbstractUser userM2 = daoUser.create(manager2);
        AbstractUser userC1 = daoUser.create(client1);
        AbstractUser userC2 = daoUser.create(client2);
        managerId1 = userM1.getId();
        managerId2 = userM2.getId();
        clientId1= userC1.getId();
        clientId2= userC2.getId();
    }

    @After
    public void afterMethod(){
        daoUser.delete(managerId1);
        daoUser.delete(managerId2);
        daoUser.delete(clientId1);
        daoUser.delete(clientId2);
    }

    @Test
    public void testGetAllQueuesForManager() throws ClientAlreadyInQueueException{
        //TODO
        ClientQueue clientQueue1 = new ClientQueue();
        ClientQueue clientQueue2 = new ClientQueue();
        //1 manager for 2 queues
        clientQueue1.addManager(managerId1);
        clientQueue2.addManager(managerId1);
        clientQueue1.addClient(clientId1);
        clientQueue2.addClient(clientId2);

        AbstractQueue queue1 = daoClientQueue.create(clientQueue1);
        AbstractQueue queue2 = daoClientQueue.create(clientQueue2);
        List <ClientQueue> testList = new ArrayList<>();
        testList.add(clientQueue1);
        testList.add(clientQueue2);
        //realList1 must have 2 queues
        List<ClientQueue> realList1 = daoClientQueue.getAllQueuesForManager(managerId1);
        assertNotNull(realList1);
        assertEquals(testList, realList1);
        //realList2 must be empty
        List<ClientQueue> realList2 = daoClientQueue.getAllQueuesForManager(managerId2);
        assertTrue(realList2.isEmpty());
    }

    @Test
    public void TestgetAllQueuesForUser() throws ClientAlreadyInQueueException {
        ClientQueue clientQueue1 = new ClientQueue();
        ClientQueue clientQueue2 = new ClientQueue();
        clientQueue1.addManager(managerId1);
        clientQueue2.addManager(managerId2);

        //1 client for 2 queues
        clientQueue1.addClient(clientId1);
        clientQueue2.addClient(clientId1);

        AbstractQueue queue1 = daoClientQueue.create(clientQueue1);
        AbstractQueue queue2 = daoClientQueue.create(clientQueue2);
        List <ClientQueue> testList = new ArrayList<>();
        testList.add(clientQueue1);
        testList.add(clientQueue2);
        //realList1 must have 2 queues
        List<ClientQueue> realList1 = daoClientQueue.getAllQueuesForUser(clientId1);
        assertNotNull(realList1);
        assertEquals(testList, realList1);
        //realList2 must be empty
        List<ClientQueue> realList2 = daoClientQueue.getAllQueuesForUser(clientId2);
        assertTrue(realList2.isEmpty());
    }

}

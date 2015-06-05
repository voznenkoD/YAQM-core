package org.perspectiveJuniors.YAQM.controller;

import javax.annotation.Resource;

import org.perspectiveJuniors.YAQM.entity.AbstractPersonalData;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.impl.Client;
import org.perspectiveJuniors.YAQM.entity.impl.PersonalData;
import org.perspectiveJuniors.YAQM.service.IClientQueueService;
import org.perspectiveJuniors.YAQM.service.impl.ClientQueueService;
import java.util.HashSet;
import java.util.Set;

import org.perspectiveJuniors.YAQM.entity.AbstractPersonalData;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.impl.Client;
import org.perspectiveJuniors.YAQM.entity.impl.PersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eljetto on 5/23/15.
 */
@RestController
public class ClientController {
    @Resource(name="clientQueueService")
    IClientQueueService clientQueueService;


    @RequestMapping(value = "/dummyCreate", method = RequestMethod.POST, consumes = "application/json")
    public long registerUser(@RequestBody Client client){
        return clientQueueService.createNewUser(client);
    }


    @RequestMapping(value = "/dummy", method = RequestMethod.GET, produces = "application/json")
    public AbstractUser dummyClient(){
        AbstractPersonalData personalData = new PersonalData("John", "McLane", "Johny");
        AbstractUser client = new Client();
        client.setPersonalData(personalData);
        return client;
    }
}

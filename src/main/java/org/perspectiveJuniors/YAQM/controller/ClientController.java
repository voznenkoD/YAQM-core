package org.perspectiveJuniors.YAQM.controller;

import javax.annotation.Resource;

import org.perspectiveJuniors.YAQM.entity.AbstractPersonalData;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.impl.Client;
import org.perspectiveJuniors.YAQM.entity.impl.PersonalData;
import org.perspectiveJuniors.YAQM.service.IClientQueueService;
import org.perspectiveJuniors.YAQM.service.impl.ClientQueueService;
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

    @RequestMapping(value = "/testClient" ,method = RequestMethod.POST, consumes = "application/json")
    public long registerUser(@RequestBody Client client){
        return clientQueueService.createNewUser(client);
    }

    @RequestMapping(value = "/testClient" ,method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Client returnDummyClient(){
        PersonalData personalData = new PersonalData();
        return  new Client(0, personalData);
    }
}

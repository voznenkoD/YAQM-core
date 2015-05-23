package org.perspectiveJuniors.YAQM.controller;

import javax.annotation.Resource;

import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.impl.Client;
import org.perspectiveJuniors.YAQM.service.impl.ClientQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eljetto on 5/23/15.
 */
@RestController
public class ClientController {
    @Resource(name="clientQueueService")
    ClientQueueService clientQueueService;

    @RequestMapping(value = "/testClient" ,method = RequestMethod.POST, consumes = "application/json")
    public void registerUser(AbstractUser user){
        clientQueueService.createNewUser(user);
    }
}

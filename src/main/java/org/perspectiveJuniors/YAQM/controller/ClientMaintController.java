package org.perspectiveJuniors.YAQM.controller;

import java.util.List;

import org.perspectiveJuniors.YAQM.entity.impl.ClientQueue;
import org.perspectiveJuniors.YAQM.exception.ClientAlreadyInQueueException;
import org.perspectiveJuniors.YAQM.exception.NotRegisteredUserException;
import org.perspectiveJuniors.YAQM.service.impl.ClientQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eljetto on 5/21/15.
 */
@RestController
@RequestMapping(value = "/client")
public class ClientMaintController {

    @Autowired
    ClientQueueService clientQueueService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ClientQueue> getAllQueuesForClient(@RequestParam("userId") long userId) {
        return clientQueueService.getQueuesThatUserIsIn(userId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void registerUserInQueue(@RequestParam("userId") long userId, @RequestParam("queueId") long queueId)
            throws NotRegisteredUserException, ClientAlreadyInQueueException {
        clientQueueService.addUserToQueue(userId,queueId);
    }
}

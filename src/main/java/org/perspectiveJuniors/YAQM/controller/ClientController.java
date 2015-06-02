package org.perspectiveJuniors.YAQM.controller;

import org.perspectiveJuniors.YAQM.entity.impl.Client;
import org.perspectiveJuniors.YAQM.service.impl.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eljetto on 6/3/15.
 */
@RestController
public class ClientController {

    @Autowired
    @Qualifier("clientService")
    ClientService clientService;

    @RequestMapping(value = "/registration" ,method = RequestMethod.POST, consumes = "application/json")
    public long registerUser(@RequestBody Client client){
        return clientService.createNewUser(client);
    }
}

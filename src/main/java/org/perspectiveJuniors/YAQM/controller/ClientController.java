package org.perspectiveJuniors.YAQM.controller;

import java.util.HashSet;
import java.util.Set;

import org.perspectiveJuniors.YAQM.entity.AbstractPersonalData;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.UserRole;
import org.perspectiveJuniors.YAQM.entity.impl.Client;
import org.perspectiveJuniors.YAQM.entity.impl.PersonalData;
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

    @RequestMapping(value = "/dummyCreate", method = RequestMethod.POST, consumes = "application/json")
    public long registerUser(@RequestBody Client client){
        return clientService.createNewUser(client);
    }

    @RequestMapping(value = "/dummy", method = RequestMethod.GET, produces = "application/json")
    public AbstractUser dummyClient(){
        AbstractPersonalData personalData = new PersonalData("John", "McLane", "Johny", "123");
        AbstractUser client = new Client();
        client.setPersonalData(personalData);
        UserRole role = new UserRole(null,"ROLE_CLIENT");
        Set<UserRole> roles = new HashSet<UserRole>();
        roles.add(role);
        client.setUserRole(roles);
        return client;
    }
}

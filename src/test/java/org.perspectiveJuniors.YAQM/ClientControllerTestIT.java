package org.perspectiveJuniors.YAQM;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.perspectiveJuniors.YAQM.controller.ClientController;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.UserRole;
import org.perspectiveJuniors.YAQM.entity.impl.Client;
import org.perspectiveJuniors.YAQM.entity.impl.PersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by vsevolod on 08.06.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ClientControllerTestIT {

    @Autowired
    ClientController clientController;

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testRegisterUser() throws RestClientException{
        PersonalData personalData = new PersonalData("John", "McLane", "Johny", "123");
        Client client = new Client();
        client.setPersonalData(personalData);
        UserRole role = new UserRole(null,"ROLE_CLIENT");
        Set<UserRole> roles = new HashSet<UserRole>();
        roles.add(role);
        client.setUserRole(roles);

        long id = clientController.registerUser(client);
        assertEquals(1L,id);
        String uri="http://localhost:8080/register";
        long result = restTemplate.postForObject(uri, client, long.class);
        assertEquals(2L,result);
        System.out.println();
    }
}

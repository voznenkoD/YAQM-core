package org.perspectiveJuniors.YAQM;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.perspectiveJuniors.YAQM.dao.IDaoUser;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.impl.Client;
import org.perspectiveJuniors.YAQM.entity.impl.PersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by eljetto on 6/1/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ClientDaoTestIT {
    @Autowired
    private IDaoUser userDao;

    @Test
    public void testCreateClient(){
        Client client = new Client();
        PersonalData personalData = new PersonalData("Joe", "Joich", "Jo");
        client.setPersonalData(personalData);
        AbstractUser user = userDao.create(client);

    }

}

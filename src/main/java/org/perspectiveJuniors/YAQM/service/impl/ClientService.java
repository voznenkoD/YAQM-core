package org.perspectiveJuniors.YAQM.service.impl;

import org.perspectiveJuniors.YAQM.dao.IDaoUser;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eljetto on 6/3/15.
 */

@Service("clientService")
public class ClientService {

    @Autowired
    private IDaoUser userDao;

    public long createNewUser(AbstractUser user) {
        return userDao.create(user).getId();
    }
}
